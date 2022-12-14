package ch12.users2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet({ "/ch12/users2/list", "/ch12/users2/login", "/ch12/users2/register", "/ch12/users2/logout",
		"/ch12/users2/delete", "/ch12/users2/update" })
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private UsersDAO dao = new UsersDAO();
	private static final String LIST = "/ch12/users2/list", LIST_VIEW = "/ch12/users2/list.jsp",
			LOGIN = "/ch12/users2/login", LOGIN_VIEW = "/ch12/users2/login.jsp", LOGOUT = "/ch12/users2/logout",
			REG = "/ch12/users2/register", REG_VIEW = "/ch12/users2/register.jsp", UPDATE = "/ch12/users2/update",
			UPDATE_VIEW = "/ch12/users2/update.jsp", DEL = "/ch12/users2/delete", MSG = "/ch12/users2/msg.jsp";

	private Users u;
	private String uid, pwd, Uname;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		String method = request.getMethod();
		HttpSession ss = request.getSession();
		String[] emailReg;

		switch (request.getServletPath()) {
		case LIST:
			List<Users> list = dao.userList();
			request.setAttribute("userList", list);
			rd = request.getRequestDispatcher(LIST_VIEW);
			rd.forward(request, response);
			break;

		case REG:
			switch (method) {
			case "GET":
				rd = request.getRequestDispatcher(REG_VIEW);
				rd.forward(request, response);
				break;

			case "POST":
				uid = request.getParameter("uid");
				String[] pwdBox = request.getParameterValues("pwd");
				Uname = request.getParameter("name");

				/** ????????? ????????? ??? */
				emailReg = request.getParameterValues("email");
				if (!emailReg[1].isEmpty())
					u = new Users(uid, pwdBox[0], Uname, emailReg[1]);
				else
					u = new Users(uid, pwdBox[0], Uname);

				/** ????????? ?????? ?????? */
				if (dao.getUserInfo(uid).getUid() == null) {
					// ???????????? ??????
					if (!pwdBox[0].equals(pwdBox[1])) {
						// ????????? -> REG
						request.setAttribute("msg", "????????? ??????????????? ????????????!");
						request.setAttribute("url", REG);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
					else {
						SetSession(ss, u.getUid(), u.getUname());
						dao.regUser(u);
						// ????????? -> LIST
						request.setAttribute("msg", u.getUname()+"??? ???????????????!");
						request.setAttribute("url", LIST);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
				} else
					// ????????? -> REG
					request.setAttribute("msg", u.getUid()+"??? ????????? ??????????????????.");
					request.setAttribute("url", REG);
					rd = request.getRequestDispatcher(MSG);
					rd.forward(request, response);
				break;
			}
			break;

		case LOGIN:
			switch (method) {
			case "GET":
				rd = request.getRequestDispatcher(LOGIN_VIEW);
				rd.forward(request, response);
				break;

			case "POST":
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				u = dao.getUserInfo(uid);

				if (u.getUid() != null) {
					if (BCrypt.checkpw(pwd, u.getPwd())) {
						/** Session Setting */
						SetSession(ss, u.getUid(), u.getUname());
						// ????????? -> LIST
						request.setAttribute("msg", u.getUname()+"??? ???????????????!");
						request.setAttribute("url", LIST);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					} else { // ???????????? ?????????
						// ????????? -> LOGIN
						request.setAttribute("msg", "??????????????? ??????????????????!");
						request.setAttribute("url", LOGIN);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
				} else {
					// ????????? -> LOGIN
					request.setAttribute("msg", "???????????? ??????????????????!");
					request.setAttribute("url", LOGIN);
					rd = request.getRequestDispatcher(MSG);
					rd.forward(request, response);
					break;
				}
				break;
			}
			break;

		case LOGOUT:
			uid = (String) ss.getAttribute("uid");
			Uname = (String) ss.getAttribute("uname");
			u = dao.getUserInfo(uid);
			ss.invalidate();
			// ????????? -> LIST
			request.setAttribute("msg", Uname+"??? ???????????? ???????????????!");
			request.setAttribute("url", LIST);
			rd = request.getRequestDispatcher(MSG);
			rd.forward(request, response);
			break;

		case UPDATE:
			switch (method) {
			case "GET":
				uid = request.getParameter("uid");
				u = dao.getUserInfo(uid);
				request.setAttribute("user", u);
				rd = request.getRequestDispatcher(UPDATE_VIEW);
				rd.forward(request, response);
				break;
			case "POST":
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				Uname = request.getParameter("name");

				/** ????????? ????????? ??? */
				emailReg = request.getParameterValues("email");
				if (!emailReg[1].isEmpty())
					u = new Users(uid, pwd, Uname, emailReg[1]);
				else
					u = new Users(uid, pwd, Uname);

				/** Session Setting */
				SetSession(ss, u.getUid(), u.getUname());

				dao.updateUser(u);
				// ????????? -> LIST
				request.setAttribute("msg", uid + " : ?????? ?????? ??????!");
				request.setAttribute("url", LIST);
				rd = request.getRequestDispatcher(MSG);
				rd.forward(request, response);
				break;
			}
			break;

		case DEL:
			uid = request.getParameter("uid");
			u = dao.getUserInfo(uid);
			dao.delUser(uid);
			response.sendRedirect(LIST);
			break;
			
		default:
			System.out.println("Controlloer ????????? ??????");
			break;
		}
		
	}

	private void SetSession(HttpSession ss, String uid, String uname) {
		ss.setAttribute("uid", uid);
		ss.setAttribute("uname", uname);
		System.out.println("[Session Setting] : " + ss.getAttribute("uid") + ", " + ss.getAttribute("uname"));
	}

}
