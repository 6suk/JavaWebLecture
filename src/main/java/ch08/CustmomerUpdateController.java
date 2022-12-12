package ch08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/customerUpdate")
public class CustmomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO dao = new CustomerDAO();
	private static final String ED = "UTF-8";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 입력을 받음
		request.setCharacterEncoding(ED);
		String uid = request.getParameter("uid");
		
		// DB에서 필요한 정보를 가져옴
		Customer c = dao.getUserInfo(uid);
		
		// Viewer를 호출
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/customerUpdateView");
		request.setAttribute("customer", c);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(ED);
		String name = request.getParameter("name");
		String uid = request.getParameter("uid");
		dao.updateUser2(uid, name);
		
		response.sendRedirect("/ch08/customer");
	}

}
