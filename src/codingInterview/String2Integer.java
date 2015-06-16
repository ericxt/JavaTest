package codingInterview;

public class String2Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "  -12a34";
		int value = atoi(str);
		System.out.println("String >>> " + str + ", Integer >>> " + value);
	}

	private static int atoi(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.length() == 0) {
			return 0;
		}

		str = str.trim();
		int i = 0;
		char flag = '+';
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		double result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-') {
			result = -result;
		}
		if (result > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		if (result < Integer.MIN_VALUE) {
			result = Integer.MIN_VALUE;
		}
		return (int) result;
	}

}
