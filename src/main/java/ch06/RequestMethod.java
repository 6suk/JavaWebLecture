package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/reqMethod")
public class RequestMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		String requestUri = request.getRequestURI();
		String servletPath = request.getServletPath();
		String servletName = request.getServerName();
		String getPathInfo = request.getPathInfo();

		String data = "contextPath : " + contextPath + "\n" + "method :"
				+ method + "\n" + "requestUri : " + requestUri
				+ "\n" + "servletPath : " + servletPath + "\n" + "servletName : " + servletName + "\n"
				+ "getPathInfo : " + getPathInfo;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>HttpServletRequest Method</h1>");
		out.print("<hr>");
//		out.print(data);


		System.out.println(data);
		String[] ulList = data.split("\n");
		out.print("<ul>");
		for(String a : ulList) {
			out.print("<li>" + a + "</li>");
		}
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
