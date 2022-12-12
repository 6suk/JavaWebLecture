package ch08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/info")
public class ContextInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** sc, ctx 동일한 결과 */
		ServletContext sc = request.getServletContext();
		ServletContext ctx = getServletContext();
		String menu = ctx.getInitParameter("menu");
		
		System.out.println("menu : " + menu);
		System.out.println("getMajorVersion : " + ctx.getMajorVersion());
		System.out.println("getRealPath : " + ctx.getRealPath("/ch08/info"));
		System.out.println("getServerInfo : " + ctx.getServerInfo());
		System.out.println("getServletContextName : " + ctx.getServletContextName());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
