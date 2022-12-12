package baseballPlayer_V2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/02/bPlayer/listView","/02/bPlayer/joinView","/02/bPlayer/updateView","/02/bPlayer/rejoinView"})
public class BpView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST = "/02/bPlayer/list", LIST_VIEW = "/02/bPlayer/listView";
	private static final String JOIN = "/02/bPlayer/join", JOIN_VIEW = "/baseballPlayer_V2/join.html";
	private static final String UPDATE = "/02/bPlayer/update", UPDATE_VIEW = "/02/bPlayer/updateView";
	private static final String REJOIN = "/02/bPlayer/rejoin", REJOIN_VIEW = "/02/bPlayer/rejoinView";
	private static PlayerDAO dao = new PlayerDAO();
	private Player p;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		String sp = request.getServletPath();
		List<Player> list;
		
		switch (sp) {
		case LIST_VIEW:
			list = (List<Player>) request.getAttribute("playerList");
			out.print(homeHTML(list));
			break;
		case UPDATE_VIEW:
			p = (Player) request.getAttribute("player");
			out.print(updateHTML(p));
			break;
		case REJOIN_VIEW:
			list = (List<Player>) request.getAttribute("byePlayerList");
			out.print(rejoinHTML(list));
			break;
			
		default:
			System.out.println("잘못된 경로입니다.");
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private StringBuilder rejoinHTML(List<Player> list) {
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
				+ "            onclick=\"location.href ='/02/bPlayer/list'\"\r\n"
				+ "          >\r\n"
				+ "            Home\r\n"
				+ "          </button>\r\n"
				+ "        </div>\r\n"
				+ "			<form method=\"post\" action=\"/02/bPlayer/rejoin\">"
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
					+ "              <td>\r\n"
					+ "                <input type=\"hidden\"  name=\"bNum\" value=\"")
			.append(x.getNum())
			.append("\"/>")
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
					+ "                <button class=\"subbtn\" type=\"submit\">재입단</button>\r\n"
					+ "              </td>");
		sb.append("</table></form>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		
		return sb;
		
	}
	
	private StringBuilder updateHTML(Player p) {
		String[] POSITION = { "투수", "포수", "내야수", "외야수" };
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
						+ "            onclick=\"location.href ='/02/bPlayer/list'\"\r\n" + "          />\r\n"
						+ "        </div>\r\n" + "\r\n"
						+ "        <form action=\"/02/bPlayer/update\" method=\"post\">\r\n"
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
	
	private StringBuilder homeHTML(List<Player> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>Home</title>\r\n"
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
				+ "        padding-inline: 28px;\r\n"
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
				+ "          <h1>선수 리스트</h1>\r\n"
				+ "          <div>\r\n"
				+ "            <input\r\n"
				+ "              class=\"mainbtn\"\r\n"
				+ "              type=\"button\"\r\n"
				+ "              value=\"선수등록\"\r\n"
				+ "              onclick=\"location.href ='/02/bPlayer/join'\"\r\n"
				+ "            />\r\n"
				+ "            <input\r\n"
				+ "              class=\"subbtn\"\r\n"
				+ "              type=\"button\"\r\n"
				+ "              value=\"선수 재입단\"\r\n"
				+ "              onclick=\"location.href ='/02/bPlayer/rejoin'\"\r\n"
				+ "            />\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <table>\r\n"
				+ "          <tr style=\"background-color: #e8f0fd42\">\r\n"
				+ "            <th>백넘버</th>\r\n"
				+ "            <th>선수이름</th>\r\n"
				+ "            <th>포지션</th>\r\n"
				+ "            <th>생년월일</th>\r\n"
				+ "            <th>키</th>\r\n"
				+ "            <th>정보 수정 / 방출</th>\r\n"
				+ "          </tr>");
		
		for(Player x : list)
			sb.append("<tr>").append("<td>").append(x.getNum()).append("</td>")
			.append("<td>").append(x.getName()).append("</td>")
			.append("<td>").append(x.getPosition()).append("</td>")
			.append("<td>").append(x.getbDay()).append("</td>")
			.append("<td>").append(x.getHeight()).append("</td>")
			.append("<td>\r\n"
					+ "              <button\r\n"
					+ "                class=\"subbtn\"\r\n"
					+ "                type=\"button\"\r\n"
					+ "                onclick=\"location.href='/02/bPlayer/update?bNum=")
			.append(x.getNum())
			.append("'\"\r\n"
					+ "              >\r\n"
					+ "                수정\r\n"
					+ "              </button>\r\n"
					+ "              <button\r\n"
					+ "                class=\"subbtn\"\r\n"
					+ "                type=\"button\"\r\n"
					+ "                onclick=\"location.href = '/02/bPlayer/delete?bNum=")
			.append(x.getNum())
			.append("'\"\r\n"
					+ "              >\r\n"
					+ "                방출\r\n"
					+ "              </button>\r\n"
					+ "            </td>\r\n"
					+ "          </tr>");
		sb.append("        </table>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		
		return sb;
	}
	

}