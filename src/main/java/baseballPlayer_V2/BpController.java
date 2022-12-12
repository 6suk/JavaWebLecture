package baseballPlayer_V2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/02/bPlayer/list", "/02/bPlayer/join", "/02/bPlayer/delete", "/02/bPlayer/update",
		"/02/bPlayer/rejoin" })
public class BpController extends HttpServlet {
	private static final String LIST = "/02/bPlayer/list", LIST_VIEW = "/02/bPlayer/listView";
	private static final String JOIN = "/02/bPlayer/join", JOIN_VIEW = "/baseballPlayer_V2/join.html";
	private static final String DEL = "/02/bPlayer/delete";
	private static final String UPDATE = "/02/bPlayer/update", UPDATE_VIEW = "/02/bPlayer/updateView";
	private static final String REJOIN = "/02/bPlayer/rejoin", REJOIN_VIEW = "/02/bPlayer/rejoinView";
	private static PlayerDAO dao = new PlayerDAO();
	private Player p;
	private RequestDispatcher rd;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String sp = request.getServletPath();
		int bNum;

		switch (sp) {
		case LIST:
			List<Player> list = dao.getPlayerList();
			request.setAttribute("playerList", list);
			rd = request.getRequestDispatcher(LIST_VIEW);
			rd.forward(request, response);
			break;

		case JOIN:
			rd = request.getRequestDispatcher(JOIN_VIEW);
			rd.forward(request, response);
			break;

		case UPDATE:
			bNum = Integer.parseInt(request.getParameter("bNum"));
			p = dao.getPlayer(bNum);
			request.setAttribute("player", p);
			rd = request.getRequestDispatcher(UPDATE_VIEW);
			rd.forward(request, response);
			break;

		case DEL:
			bNum = Integer.parseInt(request.getParameter("bNum"));
			dao.byePlayer(bNum);
			response.sendRedirect(LIST);
			break;

		case REJOIN:
			request.setAttribute("byePlayerList", dao.byePlayerList());
			rd = request.getRequestDispatcher(REJOIN_VIEW);
			rd.forward(request, response);
			break;

		default:
			System.out.println(sp);
			System.out.println("잘못된 경로입니다.");
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String sp = request.getServletPath();
		int bNum,h;
		String name,posi,bDay;

		switch (sp) {
		case JOIN:
			bNum = Integer.parseInt(request.getParameter("bNum"));
			name = request.getParameter("name");
			posi = request.getParameter("posi");
			bDay = request.getParameter("bDay");
			h = Integer.parseInt(request.getParameter("h"));
			
			/** 유효성 검사 */
			if (dao.getPlayer(bNum).getNum() != 0) {
				response.sendRedirect(JOIN_VIEW);
			} else {
				h = Integer.parseInt(request.getParameter("h"));
				p = new Player(bNum, name, posi, bDay, h);
				dao.setPlayer(p);
				response.sendRedirect(LIST);
			}
			break;

		case UPDATE:
			bNum = Integer.parseInt(request.getParameter("bNum"));
			name = request.getParameter("name");
			posi = request.getParameter("posi");
			bDay = request.getParameter("bDay");
			h = Integer.parseInt(request.getParameter("h"));
			Player p = new Player(bNum, name, posi, bDay, h);
			dao.updatePlayer(p);
			response.sendRedirect(LIST);
			break;

		case REJOIN:
			bNum = Integer.parseInt(request.getParameter("bNum"));
			dao.welcomPlayer(bNum);
			response.sendRedirect(LIST);
			break;

		default:
			System.out.println("잘못된 경로입니다.");
			break;
		}

	}

}