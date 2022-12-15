package ch12.users2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet({"/ch09/users/listView","/ch09/users/updateView"})
public class UsersView extends HttpServlet {
	private static final String LIST = "/ch09/users/list", LIST_VIEW = "/ch09/users/listView",
			LOGIN = "/ch09/users/login", LOGIN_VIEW = "/ch09/users/login.html", LOGOUT = "/ch09/users/logout",
			REG = "/ch09/users/register", REG_VIEW = "/ch09/users/register.html", UPDATE = "/ch09/users/update",
			UPDATE_VIEW = "/ch09/users/updateView", DEL = "/ch09/users/delete";
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		String sp = request.getServletPath();
		HttpSession ss = request.getSession();
		
		switch (sp) {
		case LIST_VIEW:
			List<Users> list = (List<Users>) request.getAttribute("userList");
			out.print(listHTML(list, ss));
			break;
		case UPDATE_VIEW:
			Users u = (Users) request.getAttribute("user");
			System.out.println("view" + u.toString());
			out.print(updateHTML(u));
			break;
		default:
			System.out.println("Viewer Get 잘못된 경로");
			break;
		}
	}

	
	private StringBuilder updateHTML(Users u) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "  <head>"
				+ "    <meta charset=\"UTF-8\" />"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
				+ "    <title>정보 수정</title>"
				+ "    <style>"
				+ "      * {"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',"
				+ "          'Segoe UI Symbol', sans-serif;"
				+ "        color: #333;"
				+ "      }"
				+ "      tr,"
				+ "      td,"
				+ "      th {"
				+ "        padding: 25px;"
				+ "        text-align: left;"
				+ "      }"
				+ ""
				+ "      tr:last-child,"
				+ "      td:last-child {"
				+ "        border: none;"
				+ "      }"
				+ ""
				+ "      input[type='text'],"
				+ "      [type='date'],"
				+ "      [type='number'],"
				+ "      [type='password'],"
				+ "      [type='email'] {"
				+ "        background-color: #e8f0fd8c;"
				+ "        font-size: 14px;"
				+ "        border: none;"
				+ "        padding-inline: 20px;"
				+ "        padding-block: 12px;"
				+ "        border-radius: 5px;"
				+ "      }"
				+ "      table {"
				+ "        margin: 0 auto;"
				+ "        border-collapse: collapse;"
				+ "      }"
				+ ""
				+ "      .contain-01 {"
				+ "        display: flex;"
				+ "        justify-content: center;"
				+ "      }"
				+ "      .contain-02 {"
				+ "        display: inline-block;"
				+ "      }"
				+ "      .title {"
				+ "        display: flex;"
				+ "        justify-content: space-between;"
				+ "        align-items: center;"
				+ "        padding: 20px;"
				+ "        border-bottom: solid 1px #eee;"
				+ "        align-items: flex-end;"
				+ "      }"
				+ "      input[type='submit'] {"
				+ "        font-size: 15px;"
				+ "        height: 49px;"
				+ "        border: none;"
				+ "        background-color: #4880ee;"
				+ "        color: white;"
				+ "        padding-inline: 32px;"
				+ "        border-radius: 5px;"
				+ "        width: 100%;"
				+ "      }"
				+ ""
				+ "      input:disabled {"
				+ "        background-color: #e9e9e9;"
				+ "      }"
				+ ""
				+ "      input[type='button'] {"
				+ "        background-color: #e8f0fd;"
				+ "        /* border: 1px solid #d7d7d7; */"
				+ "        height: 28px;"
				+ "        color: #4880ee;"
				+ "        border: none;"
				+ "        border-radius: 5px;"
				+ "        font-weight: 600;"
				+ "        padding-inline: 10px;"
				+ "      }"
				+ ""
				+ "      h1 {"
				+ "        margin: 0;"
				+ "      }"
				+ ""
				+ "      body {"
				+ "        margin-top: 80px;"
				+ "        margin-bottom: 100px;"
				+ "      }"
				+ "    </style>"
				+ "  </head>"
				+ "  <body>"
				+ "    <div class=\"contain-01\">"
				+ "      <div class=\"contain-02\">"
				+ "        <div class=\"title\">"
				+ "          <h1>정보 수정</h1>"
				+ "          <input type=\"button\" value=\"Home\" onclick=\"location.href ='")
		.append(LIST)
		.append("''\" />"
				+ "        </div>"
				+ ""
				+ "        <form action=\"")
		.append(UPDATE)
		.append("\" method=\"post\"><input type=\"hidden\" name=\"uid\" value=\"")
		.append(u.getUid())
		.append("\" />"
				+ "          <table>"
				+ "            <tr>"
				+ "              <th>가입일</th>"
				+ "              <td>"
				+ "                <input"
				+ "                  type=\"text\""
				+ "                  name=\"regDate\""
				+ "                  placeholder=\"아이디\""
				+ "                  required"
				+ "                  disabled"
				+ "                  value=\"")
		.append(u.getRegdate())	
		.append("\""
				+ "                />"
				+ "              </td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "              <th>아이디</th>"
				+ "              <td>"
				+ "                <input"
				+ "                  type=\"text\""
				+ "                  name=\"uid\""
				+ "                  placeholder=\"아이디\""
				+ "                  required"
				+ "                  disabled"
				+ "                  value=\"")
		.append(u.getUid())
		.append("\""
				+ "                />"
				+ "              </td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "              <th>패스워드</th>"
				+ "              <td>"
				+ "                <input"
				+ "                  type=\"password\""
				+ "                  name=\"pwd\""
				+ "                  placeholder=\"*패스워드\""
				+ "                  maxlength=\"60\""
				+ "                  required"
				+ "                />"
				+ "              </td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "              <th>이름</th>"
				+ "              <td>"
				+ "                <input"
				+ "                  type=\"text\""
				+ "                  name=\"name\""
				+ "                  placeholder=\"*이름\""
				+ "                  maxlength=\"10\""
				+ "                  required"
				+ "                  value=\"")
		.append(u.getUname())
		.append("\""
				+ "                />"
				+ "              </td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "              <th>이메일</th>"
				+ "              <td>"
				+ "                <input type=\"hidden\" name=\"email\" value=\"null\" />"
				+ "                <input"
				+ "                  type=\"email\""
				+ "                  name=\"email\""
				+ "                  placeholder=\"이메일\""
				+ "                  maxlength=\"20\""
				+ "                  value=\"");
		String email = u.getEmail() == null ? "" : u.getEmail();
		sb.append(email)
		.append("\""
				+ "                />"
				+ "              </td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "              <td colspan=\"2\">"
				+ "                <input type=\"submit\" value=\"정보수정\" />"
				+ "              </td>"
				+ "            </tr>"
				+ "          </table>"
				+ "        </form>"
				+ "      </div>"
				+ "    </div>"
				+ "  </body>"
				+ "</html>");
		return sb;
	}
	
	
	private StringBuilder listHTML(List<Users> list, HttpSession ss) {
		StringBuilder sb = new StringBuilder();
		String ssuid = (String) ss.getAttribute("uid");
		
		sb.append("<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "  <head>"
				+ "    <meta charset=\"UTF-8\" />"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
				+ "    <title>사용자 목록</title>"
				+ "    <style>"
				+ "      * {"
				+ "        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',"
				+ "          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',"
				+ "          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',"
				+ "          'Segoe UI Symbol', sans-serif;"
				+ "        color: #333;"
				+ "      }"
				+ "      h1 {"
				+ "        margin: 0;"
				+ "      }"
				+ "      .contain-01 {"
				+ "        display: flex;"
				+ "        justify-content: center;"
				+ "      }"
				+ "      .contain-02 {"
				+ "        display: inline-block;"
				+ "      }"
				+ "      .title {"
				+ "        display: flex;"
				+ "        justify-content: space-between;"
				+ "        align-items: center;"
				+ "        padding: 20px;"
				+ "        border-bottom: solid 1px #eee;"
				+ "      }"
				+ ""
				+ "      body {"
				+ "        margin-top: 80px;"
				+ "        margin-bottom: 100px;"
				+ "      }"
				+ "      tr,"
				+ "      td,"
				+ "      th {"
				+ "        padding: 25px;"
				+ "        border-bottom: solid 1px #eee;"
				+ "        text-align: center;"
				+ "      }"
				+ "      table {"
				+ "        margin: 0 auto;"
				+ "        border-collapse: collapse;"
				+ "      }"
				+ "      button:disabled {"
				+ "        background-color: #e9e9e9;"
				+ "        color: #999; cursor: default;"
				+ "      }"
				+ "      input[type='text'] {"
				+ "        font-size: 14px;"
				+ "        border: none;"
				+ "        background-color: rgba(250, 235, 215, 0.493);"
				+ "        height: 30px;"
				+ "        padding-inline: 15px;"
				+ "      }"
				+ "      button {"
				+ "        height: 28px;"
				+ "        font-weight: 600;"
				+ "        padding-inline: 10px; margin: 2px;"
				+ "      }"
				+ "      input[type='button'] {"
				+ "        font-size: 15px;"
				+ "        height: 41px;"
				+ "        padding-inline: 28px;"
				+ "      }"
				+ "      .mainbtn {"
				+ "        background-color: #4880ee;"
				+ "        color: white;"
				+ "        border: none;"
				+ "        border-radius: 5px;"
				+ "        cursor: pointer;"
				+ "      }"
				+ "      .subbtn {"
				+ "        background-color: #e8f0fd;"
				+ "        color: #4880ee;"
				+ "        border: none;"
				+ "        border-radius: 5px;"
				+ "        cursor: pointer;"
				+ "      }"
				+ "    </style>"
				+ "  </head>"
				+ "  <body>"
				+ "    <div class=\"contain-01\">"
				+ "      <div class=\"contain-02\">"
				+ "        <div class=\"title\">"
				+ "          <h1>사용자 목록</h1>"
				+ "          <div>"
				+ "            <input"
				+ "              class=\"mainbtn\""
				+ "              type=\"button\""
				+ "              value=\"");
		if(ss.getAttribute("uid") == null) {
			sb.append("로그인")
			.append("\""
					+ "              onclick=\"location.href ='")
			.append(LOGIN).append("'\"/>");
		}else {
			sb.append("로그아웃")
			.append("\""
					+ "              onclick=\"location.href ='")
			.append(LOGOUT).append("'\"/>");
		}
		
		
		sb.append("            <input"
				+ "              class=\"subbtn\""
				+ "              type=\"button\""
				+ "              value=\"회원가입\""
				+ "              onclick=\"location.href ='")
		.append(REG);
		
		if(ss.getAttribute("uid") == null) sb.append("'\"/>");
		else sb.append("'\" style=\"display: none\"/>");
		
		sb.append("          </div>"
				+ "        </div>"
				+ ""
				+ "        <table>"
				+ "          <tr style=\"background-color: #e8f0fd42\">"
				+ "            <th>아이디</th>"
//				+ "            <th>비밀번호</th>"
				+ "            <th>이름</th>"
				+ "            <th>email</th>"
				+ "            <th>가입일</th>"
				+ "            <th>수정 / 삭제</th>"
				+ "          </tr>");
		for(Users u : list) {
			sb.append("<tr>").append("<td>").append(u.getUid()).append("</td>")
//			.append("<td>").append(u.getPwd()).append("</td>")
			.append("<td>").append(u.getUname()).append("</td>")
			.append("<td>").append(u.getEmail()).append("</td>")
			.append("<td>").append(u.getRegdate()).append("</td>")
			.append("<td>")
			/** 수정버튼 시작 */
			.append("              <button"
					+ "                class=\"subbtn\""
					+ "                type=\"button\""
					+ "                onclick=\"location.href='")
			.append(UPDATE).append("?uid=").append(u.getUid()).append("'\"");
			
			if(ssuid == null || !ssuid.equals(u.getUid())) sb.append("disabled");
			else sb.append("");
			sb.append(">"
					+ "                수정"
					+ "              </button>")
			/** 수정버튼 끝 */
			
			/** 삭제버튼 시작 */
			.append("<button"
					+ "                class=\"subbtn\""
					+ "                type=\"button\""
					+ "                onclick=\"location.href = '")
			.append(DEL).append("?uid=").append(u.getUid()).append("'\"");
			
			if(ssuid == null || !ssuid.equals("admin")) sb.append("disabled");
			else sb.append("");
			sb.append(">"
					+ "                삭제"
					+ "              </button>").append("</td>")
			/** 삭제버튼 끝 */
			.append("</tr>");
			}
		sb.append("</table>"
				+ "      </div>"
				+ "    </div>"
				+ "  </body>"
				+ "</html>");
		return sb;
	}
	
	

}
