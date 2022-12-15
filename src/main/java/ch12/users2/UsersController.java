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

				/** 이메일 미기입 시 */
				emailReg = request.getParameterValues("email");
				if (!emailReg[1].isEmpty())
					u = new Users(uid, pwdBox[0], Uname, emailReg[1]);
				else
					u = new Users(uid, pwdBox[0], Uname);

				/** 아이디 중복 검사 */
				if (dao.getUserInfo(uid).getUid() == null) {
					// 패스워드 확인
					if (!pwdBox[0].equals(pwdBox[1])) {
						// 메세지 -> REG
						request.setAttribute("msg", "입력된 패스워드가 다릅니다!");
						request.setAttribute("url", REG);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
					else {
						SetSession(ss, u.getUid(), u.getUname());
						dao.regUser(u);
						// 메세지 -> LIST
						request.setAttribute("msg", u.getUname()+"님 환영합니다!");
						request.setAttribute("url", LIST);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
				} else
					// 메세지 -> REG
					request.setAttribute("msg", u.getUid()+"는 중복된 아이디입니다.");
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
						// 메세지 -> LIST
						request.setAttribute("msg", u.getUname()+"님 환영합니다!");
						request.setAttribute("url", LIST);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					} else { // 패스워드 불일치
						// 메세지 -> LOGIN
						request.setAttribute("msg", "패스워드를 확인해주세요!");
						request.setAttribute("url", LOGIN);
						rd = request.getRequestDispatcher(MSG);
						rd.forward(request, response);
					}
				} else {
					// 메세지 -> LOGIN
					request.setAttribute("msg", "아이디를 확인해주세요!");
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
			// 메세지 -> LIST
			request.setAttribute("msg", Uname+"님 로그아웃 되었습니다!");
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

				/** 이메일 미기입 시 */
				emailReg = request.getParameterValues("email");
				if (!emailReg[1].isEmpty())
					u = new Users(uid, pwd, Uname, emailReg[1]);
				else
					u = new Users(uid, pwd, Uname);

				/** Session Setting */
				SetSession(ss, u.getUid(), u.getUname());

				dao.updateUser(u);
				// 메세지 -> LIST
				request.setAttribute("msg", uid + " : 정보 수정 완료!");
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
			System.out.println("Controlloer 잘못된 경로");
			break;
		}
		
	}

	private void SetSession(HttpSession ss, String uid, String uname) {
		ss.setAttribute("uid", uid);
		ss.setAttribute("uname", uname);
		System.out.println("[Session Setting] : " + ss.getAttribute("uid") + ", " + ss.getAttribute("uname"));
	}

}
