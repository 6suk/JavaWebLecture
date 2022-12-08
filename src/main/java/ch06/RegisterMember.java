package ch06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/register")
public class RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String pwd;
	private String pwd2;
	private boolean pwdCheck;

	private String name;
	private String bDay;
	private String email;
	private String gender;
	private String[] hobby;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		uid = request.getParameter("uid");
		pwd = request.getParameter("pwd");
		pwd2 = request.getParameter("pwd2");
		pwdCheck = pwdCheck(pwd, pwd2);
		name = request.getParameter("name");
		bDay = request.getParameter("bDay");
		email = request.getParameter("email");
		gender = request.getParameter("gender");
		hobby = request.getParameterValues("hobby");

		if (hobby.length > 1) {
			hobby[0] = null;
		}

		System.out.println(Arrays.toString(hobby));
		System.out.println(uid + pwd + pwd2 + name + bDay + email + gender + hobby);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.print("<title>");
		out.print(name);
		out.print("님 환영합니다!");
		out.print("</title>");
		out.print("<style>");
		out.print(
				"* {font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo','Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI','Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji','Segoe UI Symbol', sans-serif;color: #333;} tr, td {padding: 8px;font-size: 16px;padding-right: 30px;}input {font-size: 14px;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style=\"margin: 50px\">");
		out.print("<h1>");
		out.print(name);
		out.print("님 환영합니다!");
		out.print("</h1>");
		out.print("<hr style=\"margin-bottom: 20px\" />");
		out.print("<form action=\"/ch06/registerMember.html\" method=\"post\">");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>아이디</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(uid);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>패스워드 일치</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(pwdCheck);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>이름</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(name);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>생년월일</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(bDay);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>이메일</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(email);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>성별</b>");
		out.print("</td>");
		out.print("<td>");
		out.print(gender);
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>취미</b>");
		out.print("</td>");
		out.print("<td>");
		for (String a : hobby) {
			if (a != null) {
				out.print(a);
				out.print("<br>");
			}
		}
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan=\"2\">");
		out.print(
				"<input type=\"submit\"value=\"되돌아가기\"style=\" width: 100%; height: 40px; border: none; background-color: antiquewhite; width: 300px;\"/>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	public static boolean pwdCheck(String p1, String p2) {
		if (p1.equals(p2))
			return true;
		else
			return false;
	}

}
