package ch14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch14/el01")
public class Elcontroller01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app =request.getServletContext();
		HttpSession session = request.getSession();
		app.setAttribute("aName", "application");
		session.setAttribute("sName", "session");
		request.setAttribute("rName", "request");
		request.setAttribute("name", "request name");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/el01.jsp?id=1&name=hong");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
