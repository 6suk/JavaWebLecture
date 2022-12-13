package ch09.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet({ "/ch09/users/list", "/ch09/users/login", "/ch09/users/register", "/ch09/users/logout",
		"/ch09/users/delete", "/ch09/users/update" })
public class UsersController extends HttpServlet {
	private RequestDispatcher rd;
	private UsersDAO dao = new UsersDAO();
	private static final String LIST = "/ch09/users/list", LIST_VIEW = "/ch09/users/listView",
			LOGIN = "/ch09/users/login", LOGIN_VIEW = "/ch09/users/login.html", LOGOUT = "/ch09/users/logout",
			REG = "/ch09/users/register", REG_VIEW = "/ch09/users/register.html", UPDATE = "/ch09/users/update",
			UPDATE_VIEW = "/ch09/users/updateView", DEL = "/ch09/users/delete";

	private Users u;
	private String uid, pwd, Uname, email;
	private LocalDate regdate;
	private int isDel;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		String sp = request.getServletPath();
		HttpSession ss = request.getSession();
		PrintWriter out = response.getWriter();

		switch (sp) {
		case LIST:
			List<Users> list = dao.userList();
			request.setAttribute("userList", list);
			rd = request.getRequestDispatcher(LIST_VIEW);
			rd.forward(request, response);
			break;

		case LOGIN:
			rd = request.getRequestDispatcher(LOGIN_VIEW);
			rd.forward(request, response);
			break;

		case LOGOUT:
			int check = 3;
			uid = (String) ss.getAttribute("uid");
			Uname = (String) ss.getAttribute("uname");
			u = dao.getUserInfo(uid);
			out.print(loginMsg(u, check));

			System.out.println("[로그아웃] " + uid + ", " + Uname);
			ss.invalidate();
			break;

		case REG:
			rd = request.getRequestDispatcher(REG_VIEW);
			rd.forward(request, response);
			break;

		case UPDATE:
			uid = request.getParameter("uid");
			u = dao.getUserInfo(uid);
			request.setAttribute("user", u);
			rd = request.getRequestDispatcher(UPDATE_VIEW);
			rd.forward(request, response);
			break;

		case DEL:
			uid = request.getParameter("uid");
			u = dao.getUserInfo(uid);
			dao.delUser(uid);
			out.print(loginMsg(u, 4));
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		String sp = request.getServletPath();
		HttpSession ss = request.getSession();
		PrintWriter out = response.getWriter();
		String[] emailReg;

		switch (sp) {
		case LOGIN:
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			u = dao.getUserInfo(uid);
			int sw = u.getUid() != null ? 0 : 1;
			int check;

			switch (sw) {
			//아이디 일치
			case 0:
				if (BCrypt.checkpw(pwd, u.getPwd())) {
					check = 0;
					/** Session Setting */
					SetSession(ss,u.getUid(),u.getUname());
					out.print(loginMsg(u, check));
				} else {	//패스워드 불일치
					check = 2;
					System.out.println("[패스워드 불일치]");
					out.print(loginMsg(u, check));
				}
				break;
			//아이디 불일치
			case 1:
				check = 1;
				System.out.println("[아이디 불일치]");
				out.print(loginMsg(u, check));
				break;
			}
			break;

		case UPDATE:
			uid = request.getParameter("uid");
			System.out.println(uid);
			pwd = request.getParameter("pwd");
			Uname = request.getParameter("name");

			/** 이메일 미기입 시 */
			emailReg = request.getParameterValues("email");
			System.out.println(Arrays.toString(emailReg));
			if (!emailReg[1].isEmpty())
				u = new Users(uid, pwd, Uname, emailReg[1]);
			else
				u = new Users(uid, pwd, Uname);

			/** Session Setting */
			SetSession(ss,u.getUid(),u.getUname());

			dao.updateUser(u);
			out.print(loginMsg(u, 6));
			break;

		case REG:
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			Uname = request.getParameter("name");

			/** 이메일 미기입 시 */
			emailReg = request.getParameterValues("email");
			if (!emailReg[1].isEmpty())
				u = new Users(uid, pwd, Uname, emailReg[1]);
			else
				u = new Users(uid, pwd, Uname);

			/** 아이디 중복 검사 */
			if (dao.getUserInfo(uid).getUid() == null) {
				SetSession(ss, u.getUid(), u.getUname());
				dao.regUser(u);
				out.print(loginMsg(u, 0));
			} else {
				out.print(loginMsg(u, 5));
			}

			break;

		default:
			break;
		}

	}

	private void SetSession(HttpSession ss, String uid, String uname) {
		ss.setAttribute("uid", uid);
		ss.setAttribute("uname", uname);
		System.out.println("[Session 세팅 완료 : ]" + uid + ", " + uname);
	}

	private StringBuilder loginMsg(Users u, int check) {
		StringBuilder sb = new StringBuilder();

		sb.append("<script>\r\n" + "  alert('");
		switch (check) {
		case 0:
			sb.append(u.getUname()).append("님 환영합니다!").append("')\r\n" + "  location.href = '").append(LIST)
					.append("';\r\n" + "</script>");
			break;
		case 1:
			sb.append("아이디를 확인해주세요!").append("')\r\n" + "  location.href = '").append(LOGIN)
					.append("';\r\n" + "</script>");
			break;
		case 2:
			sb.append("패스워드를 확인해주세요!").append("')\r\n" + "  location.href = '").append(LOGIN)
					.append("';\r\n" + "</script>");
			break;
		case 3:
			sb.append(u.getUname()).append("님 로그아웃 되었습니다!").append("')\r\n" + "  location.href = '").append(LIST)
					.append("';\r\n" + "</script>");
			break;
		case 4:
			sb.append(u.getUname()).append("님이 삭제 되었습니다.").append("')\r\n" + "  location.href = '").append(LIST)
					.append("';\r\n" + "</script>");
			break;
		case 5:
			sb.append(u.getUid()).append("는 중복된 아이디입니다.").append("')\r\n" + "  location.href = '").append(REG)
					.append("';\r\n" + "</script>");
			break;
		case 6:
			sb.append(u.getUid()).append(" : 정보 수정 완료!").append("')\r\n" + "  location.href = '").append(LIST)
					.append("';\r\n" + "</script>");
			break;
		default:
			break;
		}
		return sb;
	}

}