package ch08;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/src6")
public class SourceDispatchBinding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ch08/src4 doGet()");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("addr", "서울시 성북구");
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst6");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
