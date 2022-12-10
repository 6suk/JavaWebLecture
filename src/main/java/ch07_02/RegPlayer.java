package ch07_02;
/** 선수 등록 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/regPlayer")
public class RegPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlayerDAO dao = new PlayerDAO();
	private static Player p;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bNum, h;
		String name,posi,bDay;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		bNum = Integer.parseInt(request.getParameter("bNum"));
		
		/** 유효성 검사 */
		if(dao.getPlayer(bNum).getNum() != 0) {
			response.sendRedirect("/ch07_02/regPlayer.html");
		}else {
			name = request.getParameter("name");
			posi = request.getParameter("posi");
			bDay = request.getParameter("bDay");
			h = Integer.parseInt(request.getParameter("h"));
			p = new Player(bNum, name, posi, bDay, h);
			dao.setPlayer(p);
			response.sendRedirect("/ch07/playerList");
		}
		


	}

}
