package ch08.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListView
 */
@WebServlet("/ch08/customer/tmp_listView")
public class ListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) request.getAttribute("customerList");
		
		
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang=\"ko\">");
		sb.append("<head>");
		sb.append("<meta charset=\"UTF-8\" />");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		sb.append("<title>");
		sb.append("회원 리스트");
		sb.append("</title>");
		sb.append("<style>");
		sb.append(
				"* {font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo','Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI','Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji','Segoe UI Symbol', sans-serif;color: #333;} tr, td {padding: 15px;}input {font-size: 14px;}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body style=\"margin-top: 80px\">");
		sb.append("<h1 style=\"text-align: center; margin-bottom:40px\">");
		sb.append("회원 리스트");
		sb.append("</h1>");

		sb.append(
				"  <table style=\"margin: 0 auto\">\r\n" + "    <tr>\r\n" + "      <th>사용자 ID</th><th>사용자명</th><th>가입일</th><th>수정</th><th>삭제</th>\r\n" + "    </tr>");
		for (Customer c : list)
			sb.append("<tr>")
			.append("<td>").append(c.getUid()).append("</td>")
			.append("<td>").append(c.getName()).append("</td>")
			.append("<td>").append(c.getRegDate().toString()).append("</td>")
			.append("<td>").append("<a href=\"/ch08/customer/update?uid=").append(c.getUid()).append("\">수정</a>").append("</td>")
			.append("<td>").append("<a href=\"/ch08/customer/delete?uid=").append(c.getUid()).append("\">삭제</a>").append("</td>")
			.append("</tr>");
		sb.append("<tr>\r\n"
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
				+ "              onClick=\"location.href='/ch08/customer/register.html'\"\r\n"
				+ "            />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>");
		sb.append("</table>");
		sb.append("<br>");
//		sb.append("<a href=\"/ch07/registerCustomer.html\">회원가입</a>");
		sb.append("</body>");
		sb.append("</html>");
		
		out.print(sb);
		
		
	}


}
