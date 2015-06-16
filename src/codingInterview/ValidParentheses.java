package codingInterview;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "()[][]([()])";
//		boolean isValid = testValid(str);
		boolean isValid = testValidWithMap(str);
		System.out.println(isValid);
	}

	/**
	 * use hashmap
	 * @param str
	 * @return
	 */
	private static boolean testValidWithMap(String str) {
		// TODO Auto-generated method stub
		HashMap<Character,Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (map.values().contains(c)) {
				if (!stack.isEmpty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	/**
	 * common approach
	 * @param str
	 * @return
	 */
	private static boolean testValid(String str) {
		// TODO Auto-generated method stub
		int length = str.length();
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < length) {
			char c = str.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				switch (c) {
				case '(':
					if (stack.peek() == ')') {
						stack.pop();
					} else {
						stack.push(c);
					}
					break;
				case ')':
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(c);
					}
					break;
				case '[':
					if (stack.peek() == ']') {
						stack.pop();
					} else {
						stack.push(c);
					}
					break;
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push(c);
					}
					break;
				}
			}
			i++;
		}
		if (stack.isEmpty() && i >= length) {
			return true;
		}
		return false;
	}

}
