package codingInterview;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = new String[] { "2", "3", "*", "5", "+", "10", "/" };
		int result = evalRPNForJava7Above(tokens);
		System.out.println(result);
		result = evalRPNForJava7Below(tokens);
		System.out.println(result);

	}

	private static int evalRPNForJava7Below(String[] tokens) {
		// TODO Auto-generated method stub
		String operators = "+-*/";
		// char[] optrArray = operators.toCharArray();
		Stack stack = new Stack<Character>();
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
				int operand2 = Integer.parseInt(stack.pop().toString());
				int operand1 = Integer.parseInt(stack.pop().toString());

				switch (token.charAt(0)) {
				case '+':
					stack.push(operand1 + operand2);
					break;
				case '-':
					stack.push(operand1 - operand2);
					break;
				case '*':
					stack.push(operand1 * operand2);
					break;
				case '/':
					stack.push(operand1 / operand2);
					break;
				}
			}
		}
		if (stack.size() > 1) {
			throw new IllegalArgumentException("more tokens");
		}
		return Integer.parseInt(stack.pop().toString());
	}

	private static int evalRPNForJava7Above(String[] tokens) {
		// TODO Auto-generated method stub
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
				int operand2 = Integer.parseInt(stack.pop());
				int operand1 = Integer.parseInt(stack.pop());
				int tmp = 0;
				switch (token) {
				case "+":
					tmp = operand1 + operand2;
					break;
				case "-":
					tmp = operand1 - operand2;
					break;
				case "*":
					tmp = operand1 * operand2;
					break;
				case "/":
					tmp = operand1 / operand2;
					break;
				default:
					System.out.println("illegal operator");
					break;
				}
				stack.push(String.valueOf(tmp));
			}
		}
		if (stack.size() > 1) {
			throw new IllegalArgumentException("more tokens");
		}
		return Integer.parseInt(stack.pop());
	}

}
