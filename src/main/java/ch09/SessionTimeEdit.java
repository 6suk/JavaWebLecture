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

@WebServlet("/ch09/sessionTimeEdit")
public class SessionTimeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		StringBuilder sb = new StringBuilder();
		
		sb.append("세션 아이디 : " + session.getId() + "<br>")
		.append("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>")
		.append("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>")
		.append("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>")
		.append("기본 세션 유효 시간 : ").append(session.getMaxInactiveInterval()).append("<br>");
		session.setMaxInactiveInterval(5); // 5초로 설정
		sb.append("세션 유효 시간 : ").append(session.getMaxInactiveInterval()).append("<br>");
		out.print(sb);
		
		if (session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
	}


}
