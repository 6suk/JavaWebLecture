package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/currency")
public class ForeignCurrency extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WON = 100000;
	private static final String[] FOREIGN_CURRENCY = { "USD", "EUR", "JPY", "CNY" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String won_ = request.getParameter("won");
		String currency_ = request.getParameter("currency");

		int won = DEFAULT_WON;
		try {
			won = Integer.parseInt(won_);
		} catch (NumberFormatException e) {
		}

		double[] currencyRate = { 1320.2, 1386.61, 965.09, 189.31 };
		// 값이 빠질일이 없기 때문에 try catch 사용하지 않아도 됨
		int currencyIndex = Integer.parseInt(currency_);
		double exchangeAmount = won / currencyRate[currencyIndex];
		String exchangeAmountFomat = String.format("%.2f", exchangeAmount);
		System.out.printf("%,d원 ==> %s%s", won, exchangeAmountFomat, FOREIGN_CURRENCY[currencyIndex]);
		String Result = String.format("%,d원 ==> %s%s", won, exchangeAmountFomat, FOREIGN_CURRENCY[currencyIndex]);

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.print("<link rel=\"stylesheet\" href=\"../../../../myStyle.css\" />");
		out.print("<style> * {font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo','Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI','Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji','Segoe UI Symbol', sans-serif;color: #222222;}</style>");
		out.print("<title>");
		out.print("");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style=\"margin: 50px\">");
		out.print("<h1>");
		out.print("환율 계산기");
		out.print("</h1>");
		out.print("<hr>");
		out.print("<h3>");
		out.print("결과 : ");
		out.print(Result);
		out.print("</h3>");
		out.print("<button onclick=\"location.href = \'/ch06/currencyIndex.html\'\">재실행</button>");
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
