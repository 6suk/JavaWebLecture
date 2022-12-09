package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		String data = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"ko\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>구구단</title>\r\n"
				+ "    <style>\r\n"
				+ "      * {\r\n"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',\r\n"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',\r\n"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',\r\n"
				+ "          'Segoe UI Symbol', sans-serif;\r\n"
				+ "        color: #333;\r\n"
				+ "      }\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "\r\n"
				+ "  <body style=\"margin: 50px\">\r\n"
				+ "    <h1>구구단을 외자✋🏻 구구단을 외자✋🏻</h1>\r\n"
				+ "    <form action=\"/ch06/gugudan\" method=\"post\">\r\n"
				+ "      출력할 구구단 : <input type=\"number\" name=\"dan\" /><br /><br />\r\n"
				+ "      <input type=\"submit\" value=\"확인\" />\r\n"
				+ "    </form>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		out.print(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dan_ = request.getParameter("dan");
		int dan = Integer.parseInt(dan_);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(dan + " x " + i + " = " + (dan * i)).append("<br>");
		}
		System.out.println(sb);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.print("<title>");
		out.print("구구단");
		out.print("</title>");
		out.print("<style>");
		out.print(
				"* {font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo','Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI','Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji','Segoe UI Symbol', sans-serif;color: #333;} tr, td {padding: 8px;font-size: 16px;padding-right: 30px;}input {font-size: 14px;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style=\"margin: 50px\">");
		out.print("<h1>");
		out.print("구구단을 외자✋🏻 구구단을 외자✋🏻");
		out.print("</h1>");
		out.print("<hr style=\"margin-bottom: 20px\" />");
		out.print("</hr>");
		out.print("<h3>" + dan + "단" + "</h3>");
		out.print("<p>");
		out.print(sb);
		out.print("</p>");
		out.print(
				"            <button\r\n"
				+ "              style=\"\r\n"
				+ "                width: 100%;\r\n"
				+ "                height: 40px;\r\n"
				+ "                border: none;\r\n"
				+ "                background-color: antiquewhite;\r\n"
				+ "              \"\r\n"
				+ "              onclick=\"location.href='/ch06/gugudan'\"\r\n"
				+ "            >\r\n"
				+ "              재실행\r\n"
				+ "            </button>");
		out.print("</body>");
		out.print("</html>");
	}

}
