package ch07_02;
/** 선수 방출 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/deletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlayerDAO dao = new PlayerDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		dao.byePlayer(bNum);
		response.sendRedirect("/ch07/playerList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
