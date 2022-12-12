package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextFileServlet")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/tmp/init.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;

		while ((menu = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(menu, ",");
			menu_member = st.nextToken();
			menu_order = st.nextToken();
			menu_goods = st.nextToken();
		}

		out.println(menu_member + "<br>");
		out.println(menu_order + "<br>");
		out.println(menu_goods + "<br>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
