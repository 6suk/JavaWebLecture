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
 * Servlet implementation class CustomerView
 */
@WebServlet({"/ch08/customer/updateView","/ch08/customer/listView"})
public class CustomerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOME_VIEW = "/ch08/customer/listView";
	private static final String UPDATE_VIEW = "/ch08/customer/updateView";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		String sp = request.getServletPath();
		Customer c;
		
		switch (sp) {
		
		case HOME_VIEW:
			@SuppressWarnings("unchecked") List<Customer> list = (List<Customer>) request.getAttribute("customerList");
			out.print(listHTML(list));
			break;
			
		case UPDATE_VIEW:
			c = (Customer) request.getAttribute("customer");
			out.print(updateHTML(c));
			break;
			
		default:
			System.out.println("잘못된 경로");
			break;
		}
	}
	
	private StringBuilder listHTML(List<Customer> list) {
		StringBuilder sb = new StringBuilder();
		
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
		return sb;
	}
	
	private StringBuilder updateHTML(Customer c) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>회원수정</title>\r\n"
				+ "    <style>\r\n"
				+ "      * {\r\n"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',\r\n"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',\r\n"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',\r\n"
				+ "          'Segoe UI Symbol', sans-serif;\r\n"
				+ "        color: #333;\r\n"
				+ "      }\r\n"
				+ "      tr,\r\n"
				+ "      td {\r\n"
				+ "        padding: 8px;\r\n"
				+ "        font-size: 16px;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      input[type='text'] {\r\n"
				+ "        font-size: 14px;\r\n"
				+ "        border: none;\r\n"
				+ "        background-color: rgba(250, 235, 215, 0.493);\r\n"
				+ "        height: 30px;\r\n"
				+ "        padding-inline: 15px;\r\n"
				+ "      }\r\n"
				+"      input:disabled {\r\n"
				+ "        background-color: rgba(233, 233, 233, 0.493);\r\n"
				+ "      }"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body style=\"margin-top: 80px\">\r\n"
				+ "    <h1 style=\"text-align: center\">회원수정</h1>\r\n")
		.append("    <form method=\"post\" action=\"/ch08/customer/update\">\r\n")
		.append("<input type=\"hidden\" name=\"uid\" value=\"")
		.append(c.getUid())
		.append("\"> <table style=\"margin: 0 auto\">\r\n"
				+ "        <tr>\r\n"
				+ "          <td>아이디</td>")
		.append("<td>\r\n"
				+ "            <input type=\"text\" name=\"uid\" disabled value=\"")
		.append(c.getUid())
		.append("\" />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>")
		.append("<tr>\r\n"
				+ "          <td>이름</td>\r\n"
				+ "          <td>\r\n"
				+ "            <input type=\"text\" name=\"name\" maxlength=\"4\" value=\"")
		
		.append(c.getName())
		.append("\" />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>")
		.append("<tr>\r\n"
				+ "          <td>가입일자</td>\r\n"
				+ "          <td>\r\n"
				+ "            <input type=\"text\" name=\"regDate\" disabled value=\"")
		.append(c.getRegDate())
		.append("\" />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "          <td colspan=\"2\">\r\n"
				+ "            <input\r\n"
				+ "              type=\"submit\"\r\n"
				+ "              value=\"수정\"\r\n"
				+ "              style=\"\r\n"
				+ "                font-size: 16px;\r\n"
				+ "                width: 100%;\r\n"
				+ "                height: 40px;\r\n"
				+ "                border: none;\r\n"
				+ "                background-color: antiquewhite;\r\n"
				+ "                margin-top: 15px;\r\n"
				+ "              \"\r\n"
				+ "            />\r\n"
				+ "          </td>\r\n"
				+ "        </tr>\r\n"
				+ "      </table>\r\n"
				+ "    </form>\r\n"
				+ "  </body>\r\n"
				+ "</html>\r\n"
				+ "");
		return sb;
	}
	

}
