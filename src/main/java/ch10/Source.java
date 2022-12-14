package ch10;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch10/src")
public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Soure doGet()");
		response.setContentType("text/html; charset=utf-8");
		String msg = "src 한글";
		response.sendRedirect("/ch10/filterTest?msg="+msg);
	}
}
