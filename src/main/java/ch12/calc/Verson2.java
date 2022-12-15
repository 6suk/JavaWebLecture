package ch12.calc;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch12/calc/ver2")
public class Verson2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher rd;
	private static final String EVAL = "eval";
	private static final String STACK = "stack";
	private static final String JSP = "/ch12/calc/ver2.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(EVAL, "0");
		rd = request.getRequestDispatcher(JSP);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(STACK);
		Stack<Object> stack = (obj != null) ? (Stack) obj : new Stack<>();

		String num_ = request.getParameter("num");
		String op_ = request.getParameter("op");

		if (num_ != null) {
			stack.push(num_);
			session.setAttribute(STACK, stack);
			request.setAttribute(EVAL, getEval(stack));
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		} else if (op_ != null && !op_.equals("=")) {
			if (op_.equals("C"))
				stack.pop();
			else
				stack.push(op_);
			session.setAttribute(STACK, stack);
			request.setAttribute(EVAL, getEval(stack));
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		} else {
			int result = 0;
			int num2 = Integer.parseInt((String) stack.pop());
			String op = (String) stack.pop();
			int num1 = Integer.parseInt((String) stack.pop());
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			default:
				System.out.println("doPost 오류");
				break;
			}
			session.invalidate();
			request.setAttribute(EVAL, result);
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		}
	}

	String getEval(Stack<Object> stack) {
		String eval = "";
		for (Object s : stack)
			eval += (String) s + " ";
		return eval;
	}

}
