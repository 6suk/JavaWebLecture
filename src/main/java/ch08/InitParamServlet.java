package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(urlPatterns = { "/ch08/sinit", "/ch08/sinit2" }, initParams = {
		@WebInitParam(name = "email", value = "admin@jweb.com"), @WebInitParam(name = "tel", value = "010-1111-2222") })
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		String sp = request.getServletPath();

		out.print("email : " + email + "<br>");
		out.print("tel : " + tel + "<br>");
		out.print(sp);
		
		System.out.println(sp.indexOf("init2"));

		if (sp.indexOf("init2") >= 0) {
			System.out.println("init2에서 처리해 주어야 하는 일");
		} else {
			System.out.println("init에서 처리해 주어야 하는 일");
		}

	}

}
