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

@WebServlet("/ch12/calc/ver3")
public class Verson3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher rd;
	private static final String EVAL = "eval";
	private static final String STACK_LIST = "stack";
	private static final String JSP = "/ch12/calc/ver3.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(EVAL, "0");
		rd = request.getRequestDispatcher(JSP);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(STACK_LIST);
		Stack<Object> stack = (obj != null) ? (Stack) obj : new Stack<>();
		String num_ = request.getParameter("num");
		String op_ = request.getParameter("op");
		
		if (num_ != null) {
			if (stack.isEmpty()) {
				stack.push(num_);
			} else {
				String ele = (String) stack.pop();
				if (isOp(ele)) {
					stack.push(ele);
					stack.push(num_);
				} else {
					num_ = ele + num_;
					stack.push(num_);
				}
			}
			session.setAttribute(STACK_LIST, stack);
			request.setAttribute(EVAL, getEval(stack));
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		} else if (op_ != null && !op_.equals("=")) {
			if (op_.equals("C") && !stack.isEmpty()) {
				String s = (String) stack.pop();
				if (!isOp(s) && s.length() > 1) {
					s = s.substring(0, s.length() - 1);
					stack.push(s);
				}
			} else
				stack.push(op_);
			session.setAttribute(STACK_LIST, stack);
			request.setAttribute(EVAL, getEval(stack));
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		} else {
			int num2 = Integer.parseInt((String) stack.pop());
			String op = (String) stack.pop();
			int num1 = Integer.parseInt((String) stack.pop());
			int result = result(op, num1, num2);
				
			session.invalidate();
			request.setAttribute(EVAL, result);
			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
		}
	}

	
	
	boolean isOp(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	String getEval(Stack<Object> stack) {
		String eval = "";
		if(stack.isEmpty()) return eval;
		for (Object s : stack)
			eval += (String) s + " ";
		return eval;
	}
	
	int result(String op, int num1, int num2) {
		switch (op) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return 0;
		}
	}
	

}
