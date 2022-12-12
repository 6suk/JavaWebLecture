package ch08;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/src1")
public class SourceRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/ch08/src1 doGet()");

		String msg = "SourceRedirect, 한글메세지!";
		msg = URLEncoder.encode(msg, "UTF-8");	// 주소창으로 한글을 보낼 때는 반드시 인코딩을 해야한다.
		System.out.println("/ch08/src1" + msg);

		response.sendRedirect("/ch08/dst1?msg=" + msg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
