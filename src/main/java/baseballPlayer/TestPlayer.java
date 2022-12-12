package baseballPlayer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/TestPlayer")
public class TestPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlayerDAO dao = new PlayerDAO();
	private static Player p;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Player> list = dao.getPlayerList();
		list.forEach(x -> System.out.println(x));
		p = dao.getPlayer(70);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
