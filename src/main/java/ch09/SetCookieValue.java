package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch09/setCookieValue")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();

		Cookie c1 = new Cookie("Cookie-Name", "Cookie-Value");
		Cookie c2 = new Cookie("Hangul-Test", URLEncoder.encode("한글 데이터", "utf8"));
		c1.setMaxAge(24*60*60); // 쿠키 유효기간 1일
		c1.setMaxAge(-1); // 세션 쿠키
		
		response.addCookie(c1);
		response.addCookie(c2);
		Date d = new Date();
		out.print("<h1>현재시간 : " + d + "</h1>");
		out.print("<h3>현재시간을 Cookie로 저장했습니다.</h3>");
		

	}

}
