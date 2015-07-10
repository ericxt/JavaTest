package codingInterview;

import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3, 30, 34, 5, 9};
		String largestNum = largestNumber(a);
		System.out.println(largestNum);

	}

	private static String largestNumber(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return "";
		}
		int len  = a.length;
		String[] strs = new String[len];
		for (int i = 0; i < len; i++) {
			strs[i] = String.valueOf(a[i]);
		}
		// result is : 9 5 34 30 3
//		Arrays.sort(strs);
		// result is : 9 5 34 3 30
		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String left, String right) {
				// TODO Auto-generated method stub
				String leftright = left.concat(right);
				String rightleft = right.concat(left);
				return leftright.compareTo(rightleft);
			}
		});
		
		// define a comparator function
		StringBuilder builder = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			builder.append(strs[i]);
		}
		return builder.toString();
	}

}
