package ch09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch09/cookieMethod")
public class CookieMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies)
			sb.append("Name : ").append(c.getName()).append("<br>")
			.append("Value : ").append(c.getValue()).append("<br>")
			.append("Path : ").append(c.getPath()).append("<br>")
			.append("MaxAge : ").append(c.getMaxAge()).append("<br>")
			.append("Domain : ").append(c.getDomain()).append("<br>").append("<br>");
		
		out.print(sb);
		
		
	
	}


}
