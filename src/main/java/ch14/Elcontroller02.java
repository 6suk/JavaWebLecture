package ch14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch14/el02")
public class Elcontroller02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] fruits = {"감", "귤", "배"};
		request.setAttribute("fruits", fruits);
		
		List<String> list = Arrays.asList("축구", "야구", "배구");
		request.setAttribute("list", list);
		
		Map<String, String> map = new HashMap<>();
		map.put("el", "3");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/el02.jsp");
		rd.forward(request, response);
	}
}
