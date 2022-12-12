package ch08;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/src4")
public class SourceDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ch08/src4 doGet()");
		response.setContentType("text/html; charset=utf-8");
		String name = "한글";
		name = URLEncoder.encode(name, "UTF-8");
//		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst4");
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst4?name="+name);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
