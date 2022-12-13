package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch09/SessionDelete")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		HttpSession ss = request.getSession();
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("세션 아이디 : ").append(ss.getId()).append("<br>")
		.append("최초 세션 생성 시각 : ").append(new Date(ss.getCreationTime())).append("<br>")
		.append("최근 세션 접근 시각 : ").append(new Date(ss.getLastAccessedTime())).append("<br>")
		.append("세션 유효 시간 : ").append(ss.getMaxInactiveInterval()).append("<br>");
		
		if(ss.isNew()) {
			sb.append("새 세션이 만들어졌습니다.");
		}
		out.print(sb);
		ss.invalidate();
	}

}
