package codingInterview;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 4, 6, 8, 9, 1, 2, 1, 3, 1, 1, 1, 5, 7, 1, 1, 1, 1, 1};
//		int num = getMajority1(a);
//		System.out.println(num);
		
		int num = getMajority2(a);
		System.out.println(num);

	}

	/**
	 * exist majority element
	 * sort the array, and return the middle element
	 * o(nlogn)
	 * @param a
	 * @return
	 */
	private static int getMajority2(int[] a) {
		// TODO Auto-generated method stub
		if (a.length == 1) {
			return a[0];
		}
		
		Arrays.sort(a);
		
		return a[a.length / 2];
	}

	/**
	 * supposing there is majority element sort the array, and find the majority
	 * element o(nlogn)
	 * 
	 * @param a
	 * @return
	 */
	private static int getMajority1(int[] a) {
		// TODO Auto-generated method stub
		if (a.length == 1) {
			return a[0];
		}

		Arrays.sort(a);
		int count = 0;
		int prev = a[0];
		for (int i = 1; i < a.length; i++) {
			if (prev == a[i]) {
				count++;
				if (count >= a.length / 2) {
					return prev;
				}
			} else {
				count = 0;
				prev = a[i];
			}
		}
		return Integer.MIN_VALUE;
	}

}
