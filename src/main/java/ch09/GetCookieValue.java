package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch09/getCookieValue")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		Cookie[] allC = request.getCookies();
		
		for(Cookie c : allC) {
			String kValue = URLDecoder.decode(c.getValue(),"utf-8");
			if(c.getName().equals("Hangul-Test"))
				out.print("<h3>" + c.getName() + ", " + kValue + "<h3>");
			else out.print("<h3>" + c.getName() + ", " + c.getValue() + "<h3>");
		}
		
	}


}
