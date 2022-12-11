package ch07_02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/updatePlayer")
public class UpdatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlayerDAO dao = new PlayerDAO();
	private static final String[] POSITION = { "투수", "포수", "내야수", "외야수" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		Player p = dao.getPlayer(bNum);
		PrintWriter out = response.getWriter();
		out.print(html(p));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int h = Integer.parseInt(request.getParameter("h"));
		String name = request.getParameter("name");
		String posi = request.getParameter("posi");
		String bDay = request.getParameter("bDay");
		Player p = new Player(bNum,name,posi,bDay,h);
		System.out.println(p);
		dao.updatePlayer(p);
		response.sendRedirect("/ch07/playerList");

	}

	private StringBuilder html(Player p) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>선수 수정</title>\r\n" + "    <style>\r\n" + "      * {\r\n"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',\r\n"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',\r\n"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',\r\n"
				+ "          'Segoe UI Symbol', sans-serif;\r\n" + "        color: #333;\r\n" + "      }\r\n"
				+ "      tr,\r\n" + "      td,\r\n" + "      th {\r\n" + "        padding: 25px;\r\n"
				+ "        border-bottom: solid 1px #eee;\r\n" + "        text-align: left;\r\n" + "      }\r\n"
				+ "\r\n" + "      tr:last-child,\r\n" + "      td:last-child {\r\n" + "        border: none;\r\n"
				+ "      }\r\n" + "\r\n" + "      input[type='text'],\r\n" + "      [type='date'],\r\n"
				+ "      [type='number'] {\r\n" + "        background-color: #e8f0fd8c;\r\n"
				+ "        font-size: 14px;\r\n" + "        border: none;\r\n" + "        padding-inline: 20px;\r\n"
				+ "        padding-block: 12px;\r\n" + "        border-radius: 5px;\r\n" + "        width: 90%;\r\n"
				+ "      }\r\n" + "      table {\r\n" + "        margin: 0 auto;\r\n"
				+ "        border-collapse: collapse;\r\n" + "      }\r\n" + "\r\n" + "      .contain-01 {\r\n"
				+ "        display: flex;\r\n" + "        justify-content: center;\r\n" + "      }\r\n"
				+ "      .contain-02 {\r\n" + "        display: inline-block;\r\n" + "      }\r\n"
				+ "      .title {\r\n" + "        display: flex;\r\n" + "        justify-content: space-between;\r\n"
				+ "        align-items: center;\r\n" + "        padding: 20px;\r\n"
				+ "        border-bottom: solid 1px #eee;\r\n" + "        align-items: flex-end;\r\n" + "      }\r\n"
				+ "      input[type='submit'] {\r\n" + "        font-size: 15px;\r\n" + "        height: 49px;\r\n"
				+ "        border: none;\r\n" + "        background-color: #4880ee;\r\n" + "        color: white;\r\n"
				+ "        padding-inline: 32px;\r\n" + "        border-radius: 5px;\r\n" + "        width: 100%;\r\n"
				+ "      }\r\n" +"      input:disabled {\r\n"
						+ "        background-color: #e9e9e9;\r\n"
						+ "      }"+ "      input[type='button'] {\r\n" + "        background-color: #e8f0fd;\r\n"
				+ "        /* border: 1px solid #d7d7d7; */\r\n" + "        height: 28px;\r\n"
				+ "        color: #4880ee;\r\n" + "        border: none;\r\n" + "        border-radius: 5px;\r\n"
				+ "        font-weight: 600;\r\n" + "        padding-inline: 10px;\r\n" + "      }\r\n"
				+ "      h1 {\r\n" + "        margin: 0;\r\n" + "      }\r\n" + "\r\n" + "      body {\r\n"
				+ "        margin-top: 80px;\r\n" + "        margin-bottom: 100px;\r\n" + "      }\r\n"
				+ "    </style>\r\n" + "  </head>\r\n" + "  <body>\r\n" + "    <div class=\"contain-01\">\r\n"
				+ "      <div class=\"contain-02\">\r\n" + "        <div class=\"title\">\r\n" + "          <h1>")
				.append(p.getNum())
				.append("번 선수 수정</h1>\r\n" + "          <input\r\n" + "            type=\"button\"\r\n"
						+ "            value=\"Home\"\r\n"
						+ "            onclick=\"location.href ='/ch07/playerList'\"\r\n" + "          />\r\n"
						+ "        </div>\r\n" + "\r\n"
						+ "        <form action=\"/ch07/updatePlayer\" method=\"post\">\r\n"
						+ "        <input type=\"hidden\" name=\"bNum\" value=\"")
				.append(p.getNum())
				.append("\">\r\n" + "          <table>\r\n" + "            <tr>\r\n" + "              <th>백넘버</th>\r\n"
						+ "              <td>\r\n" + "                <input\r\n"
						+ "                  type=\"number\"\r\n" + "                  name=\"bNum\"\r\n"
						+ "                  placeholder=\"백넘버\"\r\n" + "                  required\r\n"
						+ "                  disabled\r\n" + "                  value=\"")
				.append(p.getNum())
				.append("\"\r\n" + "                />\r\n" + "              </td>\r\n" + "            </tr>\r\n"
						+ "            <tr>\r\n" + "              <th>선수 이름</th>\r\n" + "              <td>\r\n"
						+ "                <input\r\n" + "                  type=\"text\"\r\n"
						+ "                  name=\"name\"\r\n" + "                  placeholder=\"선수 이름\"\r\n"
						+ "                  maxlength=\"4\"\r\n" + "                  required\r\n"
						+ "                  value=\"")
				.append(p.getName())
				.append("\"\r\n" + "                />\r\n" + "              </td>\r\n" + "            </tr>\r\n"
						+ "            <tr>\r\n" + "              <th>생년월일</th>\r\n" + "              <td>\r\n"
						+ "                <input\r\n" + "                  type=\"date\"\r\n"
						+ "                  name=\"bDay\"\r\n" + "                  placeholder=\"생년월일\"\r\n"
						+ "                  required\r\n" + "                  value=\"")
				.append(p.getbDay())
				.append("\"\r\n" + "                />\r\n" + "              </td>\r\n" + "            </tr>\r\n"
						+ "            <tr>\r\n" + "              <th>키</th>\r\n" + "              <td>\r\n"
						+ "                <input\r\n" + "                  type=\"number\"\r\n"
						+ "                  name=\"h\"\r\n" + "                  placeholder=\"키(신장)\"\r\n"
						+ "                  max=\"250\"\r\n" + "                  required\r\n"
						+ "                  value=\"")
				.append(p.getHeight())
				.append("\"\r\n" + "                />\r\n" + "              </td>\r\n" + "            </tr>\r\n"
						+ "            <tr>\r\n" + "              <th>포지션</th>\r\n" + "              <td>");

		for (String a : POSITION) {
			if (a.equals(p.getPosition())) {
				sb.append("<input type=\"radio\" name=\"posi\" value=\"").append(a).append("\" checked/>").append(a)
						.append("\n");
			} else {
				sb.append("<input type=\"radio\" name=\"posi\" value=\"").append(a).append("\" />").append(a)
						.append("\n");
			}
		}
		sb.append("              </td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "              <td colspan=\"2\">\r\n"
				+ "                <input type=\"submit\" value=\"선수수정\" />\r\n" + "              </td>\r\n"
				+ "            </tr>\r\n" + "          </table>\r\n" + "        </form>\r\n" + "      </div>\r\n"
				+ "    </div>\r\n" + "  </body>\r\n" + "</html>");
		return sb;

	}

}
