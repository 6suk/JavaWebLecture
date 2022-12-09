package ch07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/updateCustomer")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String name;
	private static CustomerDAO dao = new CustomerDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		uid = request.getParameter("uid");
		Customer c = dao.getUserInfo(uid);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
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
		.append("    <form method=\"post\" action=\"/ch07/registerCustomer\" enctype=\"UTF-8\">\r\n")
		.append("<input type=\"hidden\" name=\"uid\" value=\"")
		.append(c.getUid())
		.append("      \"> <table style=\"margin: 0 auto\">\r\n"
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
		out.print(sb);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		uid = request.getParameter("uid");
		name = request.getParameter("name");
		dao.updateUser2(uid, name);
		
		response.sendRedirect("/ch07/customerList");
	}
}
