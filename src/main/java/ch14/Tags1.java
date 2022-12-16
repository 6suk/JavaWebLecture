package ch14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch14/tags1")
public class Tags1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address addr1 = new Address(12345, "서울", "한국");
		Address addr2 = new Address(67891, "용인", "한국");
		
		Member mem1 = new Member(101, "홍길동", addr1);
		Member mem2 = new Member(102, "고뚱이", addr2);
		
		request.setAttribute("m1", mem1);
		request.setAttribute("m2", mem2);
		
		Member[] members = {mem1, mem2};
		request.setAttribute("members", members);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/tags1.jsp");
		rd.forward(request, response);
	}
}
