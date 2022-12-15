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

@WebServlet("/ch12/calc/ver3_2")
public class Verson3_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher rd;
	private static final String JSP = "/ch12/calc/ver3_2.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("eval", "0");
		rd = request.getRequestDispatcher(JSP);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("ssStack");
		@SuppressWarnings("unchecked")
		Stack<Object> stack = obj != null ? (Stack<Object>) obj : new Stack<>();
		String num_ = request.getParameter("num");
		String op_ = request.getParameter("op");
		String action_ = request.getParameter("action");
		String ele = null;
		int check = stack.isEmpty() ? 0 : num_ != null ? 1 : op_ != null ? 2 : action_.equals("C") ? 3 : 4;
		System.out.println(check);
		System.out.println(stack.toString());

		switch (check) {

		/** 첫 입력 */
		case 0:
			if (num_ != null)
				stack.push(num_);
			else
				stack.empty();
			sendSetting(request, response, stack);
			break;

		/** 숫자 입력 */
		case 1:
			ele = (String) stack.pop();
			if (isOp(ele)) {
				stack.push(ele);
				stack.push(num_);
			} else {
				// 앞 input이 숫자일 경우 합쳐주기
				num_ = ele + num_;
				stack.push(num_);
			}
			sendSetting(request, response, stack);
			break;

		/** 부호 입력 */
		case 2:
			ele = (String) stack.pop();
			if (!isOp(ele)) {
				stack.push(ele);
				stack.push(op_);
			} else {
				// 앞 input이 부호일 경우 다시 입력한 부호로 바꿔주기
				stack.push(op_);
			}
			sendSetting(request, response, stack);
			break;

		/** BC 입력 */
		case 3:
			ele = (String) stack.pop();

			// 앞 input이 숫자일 때
			if (!isOp(ele) && ele.length() > 1) {
				ele = ele.substring(0, ele.length() - 1);
				stack.push(ele);
			}
			sendSetting(request, response, stack);
			break;

		/** = 입력 */
		case 4:
			int result = result((String) stack.pop(), (String) stack.pop(), (String) stack.pop());
			request.setAttribute("eval", result);

			rd = request.getRequestDispatcher(JSP);
			rd.forward(request, response);
			break;

		default:
			System.out.println("오류");
			break;

		}

	}

	private void sendSetting(HttpServletRequest request, HttpServletResponse response, Stack<Object> stack)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("ssStack", stack);
		request.setAttribute("eval", getEval(stack));
		rd = request.getRequestDispatcher(JSP);
		rd.forward(request, response);
	}

	boolean isOp(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	String getEval(Stack<Object> stack) {
		String eval = "";
		if (stack.isEmpty())
			return eval;
		for (Object s : stack)
			eval += (String) s + " ";
		return eval;
	}

	int result(String num2_, String op, String num1_) {
		int num1 = Integer.parseInt(num1_);
		int num2 = Integer.parseInt(num2_);

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
