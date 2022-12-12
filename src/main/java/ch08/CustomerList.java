package ch08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/customerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EC = "UTF-8";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(EC);
		response.setContentType("text/html; charset=" + EC);
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) request.getAttribute("customer");
		StringBuilder sb = new StringBuilder();
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.print("<title>");
		out.print("회원 리스트");
		out.print("</title>");
		out.print("<style>");
		out.print(
				"* {font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo','Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI','Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji','Segoe UI Symbol', sans-serif;color: #333;} tr, td {padding: 15px;}input {font-size: 14px;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style=\"margin-top: 80px\">");
		out.print("<h1 style=\"text-align: center; margin-bottom:40px\">");
		out.print("회원 리스트");
		out.print("</h1>");

		sb.append(
				"  <table style=\"margin: 0 auto\">\r\n" + "    <tr>\r\n" + "      <th>사용자 ID</th><th>사용자명</th><th>가입일</th><th>수정</th><th>삭제</th>\r\n" + "    </tr>");
		for (Customer c : list)
			sb.append("<tr>")
			.append("<td>").append(c.getUid()).append("</td>")
			.append("<td>").append(c.getName()).append("</td>")
			.append("<td>").append(c.getRegDate().toString()).append("</td>")
			.append("<td>").append("<a href=\"/ch08/customerUpdate?uid=").append(c.getUid()).append("\">수정</a>").append("</td>")
			.append("<td>").append("<a href=\"/ch08/deleteCustomer?uid=").append(c.getUid()).append("\">삭제</a>").append("</td>")
			.append("</tr>");

		out.print(sb);
		out.print("<tr>\r\n"
				+ "          <td colspan=\"5\">\r\n"
				+ "            <input\r\n"
				+ "              type=\"button\"\r\n"
				+ "              value=\"회원가입\"\r\n"
				+ "              style=\"\r\n"
				+ "                font-size: 16px;\r\n"
				+ "                width: 100%;\r\n"
				+ "                height: 40px;\r\n"
				+ "                border: none;\r\n"
				+ "                background-color: antiquewhite;\r\n"
				+ "                margin-top: 15px;\""
				+ "              \r\n"
				+ "              onClick=\"location.href='/ch07/registerCustomer.html'\"\r\n"
				+ "            />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>");
		out.print("</table>");
		out.print("<br>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
