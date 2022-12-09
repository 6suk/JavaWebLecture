package ch07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch07/registerCustomer")
public class CustomerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		CustomerDAO dao = new CustomerDAO();
		
		Customer c = dao.getUserInfo(uid);
		if(c.getUid() != null) {
			response.sendRedirect("/ch07/registerCustomer.html");
		}else {
			c = new Customer(uid,name);
			dao.insertUser(c);
			response.sendRedirect("/ch07/customerList");
		}
	}

}
