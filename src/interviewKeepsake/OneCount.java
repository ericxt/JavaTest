package interviewKeepsake;

public class OneCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int res = 1;
		while ((getCount(n) + res) != n) {
			res += getCount(n);
			n++;
		}
		System.out.println(n);

	}

	private static int getCount(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		String num = n + "";
		int length = num.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				if ('1' == num.charAt(i)) {
					count++;
				}
			}
		}
		return count;
	}

}
