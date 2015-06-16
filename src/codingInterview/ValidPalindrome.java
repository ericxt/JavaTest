package codingInterview;

import java.util.Stack;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Red rum,sir , is murder";
		// String str = "abcba";
		// boolean isValid = myTestValid2(str);
		// boolean isValid = testValidWithStack(str);
//		boolean isValid = testValidMoreSimple(str);
//		System.out.println(isValid);

		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			myTestValid1(str);
		}
		long endTime = System.nanoTime();
		System.out.println("myTestValid1        >>> cost time : "
				+ (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			myTestValid2(str);
		}
		endTime = System.nanoTime();
		System.out.println("myTestValid2        >>> cost time : "
				+ (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			testValidWithStack(str);
		}
		endTime = System.nanoTime();
		System.out.println("testValidWithStack  >>> cost time : "
				+ (endTime - startTime));
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			testValidMoreSimple(str);
		}
		endTime = System.nanoTime();
		System.out.println("testValidMoreSimple >>> cost time : "
				+ (endTime - startTime));
	}

	/**
	 * use two pointers, more simple
	 * 
	 * @param str
	 * @return
	 */
	private static boolean testValidMoreSimple(String str) {
		// TODO Auto-generated method stub
		if (str == null) {
			return false;
		}
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = str.length();
		if (len < 2) {
			return true;
		}
		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * low efficiency
	 * 
	 * @param str
	 * @return
	 */
	private static boolean testValidWithStack(String str) {
		// TODO Auto-generated method stub
		if (str == null) {
			return false;
		}
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = str.length();
		if (len < 2) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while (index < len / 2) {
			stack.push(str.charAt(index));
			index++;
		}
		if (len % 2 == 1) {
			index++;
		}
		while (index < len) {
			if (str.charAt(index) == stack.pop()) {
				index++;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean myTestValid2(String str) {
		// TODO Auto-generated method stub
		if (str == null) {
			return false;
		}
		str = str.trim();
		int len = str.length();
		if (len == 0) {
			return true;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				builder.append(ch);
			}
		}
		str = builder.toString().toLowerCase();
		len = str.length();

		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}

			if (end - start == 1) {
				break;
			}
		}
		return true;
	}

	private static boolean myTestValid1(String str) {
		// TODO Auto-generated method stub
		if (str == null) {
			return false;
		}
		str = str.trim().toLowerCase();
		int len = str.length();
		if (len == 0) {
			return true;
		}
		int start = 0;
		int end = len - 1;
		while (start < end) {
			char a = str.charAt(start);
			char b = str.charAt(end);
			if (a == b && Character.isLetterOrDigit(a)
					&& Character.isLetterOrDigit(b)) {
				start++;
				end--;
			} else if (!Character.isLetterOrDigit(a)) {
				start++;
			} else if (!Character.isLetterOrDigit(b)) {
				end--;
			} else {
				return false;
			}
			if (end - start == 1) {
				break;
			}
		}
		return true;
	}

}
