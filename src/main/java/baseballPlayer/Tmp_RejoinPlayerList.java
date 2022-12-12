package baseballPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/tmp_rejoinPlayerList")
public class Tmp_RejoinPlayerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlayerDAO dao = new PlayerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Player> list = dao.byePlayerList();
		out.print(html(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private StringBuilder html(List<Player> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>방출 선수 리스트</title>\r\n"
				+ "    <style>\r\n"
				+ "      * {\r\n"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',\r\n"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',\r\n"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',\r\n"
				+ "          'Segoe UI Symbol', sans-serif;\r\n"
				+ "        color: #333;\r\n"
				+ "      }\r\n"
				+ "      h1 {\r\n"
				+ "        margin: 0;\r\n"
				+ "      }\r\n"
				+ "      .contain-01 {\r\n"
				+ "        display: flex;\r\n"
				+ "        justify-content: center;\r\n"
				+ "      }\r\n"
				+ "      .contain-02 {\r\n"
				+ "        display: inline-block;\r\n"
				+ "      }\r\n"
				+ "      .title {\r\n"
				+ "        display: flex;\r\n"
				+ "        justify-content: space-between;\r\n"
				+ "        align-items: center;\r\n"
				+ "        padding: 20px;\r\n"
				+ "        border-bottom: solid 1px #eee;\r\n"
				+ "        align-items: flex-end;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      body {\r\n"
				+ "        margin-top: 80px;\r\n"
				+ "        margin-bottom: 100px;\r\n"
				+ "      }\r\n"
				+ "      tr,\r\n"
				+ "      td,\r\n"
				+ "      th {\r\n"
				+ "        padding: 25px;\r\n"
				+ "        border-bottom: solid 1px #eee;\r\n"
				+ "        text-align: center;\r\n"
				+ "      }\r\n"
				+ "      table {\r\n"
				+ "        margin: 0 auto;\r\n"
				+ "        border-collapse: collapse;\r\n"
				+ "      }\r\n"
				+ "      input[type='text'] {\r\n"
				+ "        font-size: 14px;\r\n"
				+ "        border: none;\r\n"
				+ "        background-color: rgba(250, 235, 215, 0.493);\r\n"
				+ "        height: 30px;\r\n"
				+ "        padding-inline: 15px;\r\n"
				+ "      }\r\n"
				+ "      button {\r\n"
				+ "        height: 28px;\r\n"
				+ "        font-weight: 600;\r\n"
				+ "        padding-inline: 10px;\r\n"
				+ "      }\r\n"
				+ "      input[type='button'] {\r\n"
				+ "        font-size: 15px;\r\n"
				+ "        height: 41px;\r\n"
				+ "        padding-inline: 32px;\r\n"
				+ "      }\r\n"
				+ "      .mainbtn {\r\n"
				+ "        background-color: #4880ee;\r\n"
				+ "        color: white;\r\n"
				+ "        border: none;\r\n"
				+ "        border-radius: 5px;\r\n"
				+ "        cursor: pointer;\r\n"
				+ "      }\r\n"
				+ "      .subbtn {\r\n"
				+ "        background-color: #e8f0fd;\r\n"
				+ "        color: #4880ee;\r\n"
				+ "        border: none;\r\n"
				+ "        border-radius: 5px;\r\n"
				+ "        cursor: pointer;\r\n"
				+ "      }\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    <div class=\"contain-01\">\r\n"
				+ "      <div class=\"contain-02\">\r\n"
				+ "        <div class=\"title\">\r\n"
				+ "          <h1>방출 선수 리스트</h1>\r\n"
				+ "          <button\r\n"
				+ "            type=\"button\"\r\n"
				+ "            class=\"mainbtn\"\r\n"
				+ "            onclick=\"location.href ='/ch07/playerList'\"\r\n"
				+ "          >\r\n"
				+ "            Home\r\n"
				+ "          </button>\r\n"
				+ "        </div>\r\n"
				+ "			<form method=\"post\" action=\"/ch07/rejoinPlayer\">"
				+ "        <table>\r\n"
				+ "          <tr style=\"background-color: #e8f0fd42\">\r\n"
				+ "            <th>백넘버</th>\r\n"
				+ "            <th>선수이름</th>\r\n"
				+ "            <th>포지션</th>\r\n"
				+ "            <th>생년월일</th>\r\n"
				+ "            <th>키</th>\r\n"
				+ "            <th>재입단</th>\r\n"
				+ "          </tr>");
		for(Player x : list)
			sb.append("<tr>\r\n"
					+ "            <td><input type=\"hidden\" name=\"bNum\">")
			.append(x.getNum())
			.append("</input></td>\r\n"
					+ "            <td>")
			.append(x.getName())
			.append("</td>\r\n"
					+ "            <td>")
			.append(x.getPosition())
			.append("</td>\r\n"
					+ "            <td>")
			.append(x.getbDay())
			.append("</td>\r\n"
					+ "            <td>")
			.append(x.getHeight())
			.append("</td>")
			.append("<td>\r\n"
					+ "                <button\r\n"
					+ "                  class=\"subbtn\"\r\n"
					+ "                  type=\"button\"\r\n"
					+ "                  onclick=\"location.href='/ch07/rejoinPlayer?bNum=")
			.append(x.getNum())
			.append("'\"\r\n"
					+ "                >\r\n"
					+ "                  재입단\r\n"
					+ "                </button>\r\n"
					+ "              </td>\r\n"
					+ "            </tr>");
		sb.append("</table></form>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		
		return sb;
		
	}
	

}
