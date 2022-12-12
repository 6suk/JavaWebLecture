package ch08.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/ch08/customer/list", "/ch08/customer/register", "/ch08/customer/update", "/ch08/customer/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HOME = "/ch08/customer/list";
	private static final String HOME_VIEW = "/ch08/customer/listView";
	private static final String REG = "/ch08/customer/register";
	private static final String REG_VIEW = "/ch08/customer/register.html";
	private static final String UPDATE = "/ch08/customer/update";
	private static final String UPDATE_VIEW = "/ch08/customer/updateView";
	private static final String DEL = "/ch08/customer/delete";
	private static CustomerDAO dao = new CustomerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid, name;
		Customer c;
		RequestDispatcher rd;
		request.setCharacterEncoding("UTF-8");
		String sp = request.getServletPath();
		response.setContentType("text/html; charset=UTF-8");

		System.out.println(sp);
		switch (sp) {
		case HOME:
			List<Customer> list = dao.getCustomers();
			request.setAttribute("customerList", list);
			rd = request.getRequestDispatcher(HOME_VIEW);
			rd.forward(request, response);
			break;

		case REG:
			response.sendRedirect(REG_VIEW);
			break;

		case UPDATE:
			uid = request.getParameter("uid");
			c = dao.getUserInfo(uid);
			rd = request.getRequestDispatcher(UPDATE_VIEW);
			request.setAttribute("customer", c);
			System.out.println(c);
			rd.forward(request, response);
			break;

		case DEL:
			uid = request.getParameter("uid");
			dao = new CustomerDAO();
			dao.deleteUser(uid);
			response.sendRedirect(HOME);
			break;

		default:
			System.out.println("잘못된 경로");
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid;
		String name;
		Customer c;

		request.setCharacterEncoding("UTF-8");
		String sp = request.getServletPath();
		response.setContentType("text/html; charset=UTF-8");

		switch (sp) {
		case REG:
			uid = request.getParameter("uid");
			name = request.getParameter("name");
			c = dao.getUserInfo(uid);
			if (c.getUid() != null) {
				response.sendRedirect(REG_VIEW);
			} else {
				c = new Customer(uid, name);
				dao.insertUser(c);
				response.sendRedirect(HOME);
			}
			break;

		case UPDATE:
			name = request.getParameter("name");
			uid = request.getParameter("uid");
			dao.updateUser2(uid, name);
			response.sendRedirect(HOME);
			break;

		default:
			System.out.println("잘못된 경로");
			break;
		}

	}

}
