package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/Params")
public class Params extends HttpServlet {
	private static final int DEFAULT_COUNT = 5;
	private static final String[] FOOD_ARRAY = { "짜장면", "스테이크", "라면", "만두" };
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//		http://localhost:8080/ch06/Params?uid=hong&cnt=5
		System.out.println("Params.doGet() method");
		String uid = request.getParameter("uid");
		// cnt 오류 처리
		int cnt = DEFAULT_COUNT;
		try {
			String cnt_ = request.getParameter("cnt");
			cnt = Integer.parseInt(cnt_);
		} catch (NumberFormatException e) {
		}
		for (int i = 1; i <= cnt; i++)
			System.out.println(i + ", uid : " + uid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Params.doPost() method");
		request.setCharacterEncoding("utf-8");

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String[] skills = request.getParameterValues("skill");
		String food = request.getParameter("food");

		System.out.printf("uid : %s\npwd : %s\nFood : %s\n", uid, pwd, FOOD_ARRAY[Integer.parseInt(food) - 1]);
		for (String skill : skills) {
			System.out.println("skill : " + skill);
		}

		String wecolme = uid + "님 환영합니다";

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.print("<title>");
		out.print(wecolme);
		out.print("</title>");
		out.print("</head>");
		out.print("<body style=\"margin: 50px;\">");
		out.print("<h1>");
		out.print(wecolme);
		out.print("</h1>");
		out.print("<hr />");
		out.print("<ul>");
		out.print("<li>");
		out.print("<b>uid : </b>" + uid);
		out.print("</li>");
		out.print("<li>");
		out.print("<b>pwd : </b>" + pwd);
		out.print("</li>");
		for (String skill : skills) {
			out.print("<li>");
			out.print("<b>skill : </b>" + skill);
			out.print("</li>");
		}
		out.print("<li>");
		out.print("<b>food : </b>" + FOOD_ARRAY[Integer.parseInt(food) - 1]);
		out.print("</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");

	}
}