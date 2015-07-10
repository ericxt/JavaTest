package codingInterview;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 1, 1, 2, 2, 3};
//		int count = removeDuplicates1(a);
//		System.out.println(count);
//		int[] newArray = removeDuplicates2(a);
//		printArray(newArray);
		
//		int count = removeDuplicates3(a);
//		System.out.println(count);
		
//		int count = removeDuplicates4(a);
//		printArray(a);
//		System.out.println(count);
		
//		int count = removeDuplicates5(a);
//		printArray(a);
//		System.out.println(count);
		
		int count = removeDuplicates6(a);
		printArray(a);
		System.out.println(count);

	}

	/**
	 * modify the array in place, and return the allowed number of array
	 * @param a
	 * @return
	 */
	private static int removeDuplicates6(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return 0;
		}
		
		int prev = 1;
		int cur = 2;
		while (cur < a.length) {
			if (a[cur] == a[prev] && a[cur] == a[prev - 1]) {
				cur++;
			} else {
				prev++;
				a[prev] = a[cur];
				cur++;
			}
		}
		return prev + 1;
	}

	/**
	 * modify the array in place, and return the allowed number fo array
	 * @param a
	 * @return
	 */
	private static int removeDuplicates5(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return 0;
		}
		
		int pre = a[0];
		boolean flag = false;
		int count = 0;
		int j = 1;
		
		for (int i = 1; i < a.length; i++) {
			int cur = a[i];
			if (cur == pre) {
				if (!flag) {
					flag = true;
					a[j++] = cur;
					continue;
				} else {
					count++;
				}
			} else {
				flag = false;
				a[j++] = cur;
			}
			pre = cur;
		}
		return a.length - count;
	}

	/**
	 * duplicates are allowed at most twice
	 * naive, only return the allowed number of the array, don't change the original array
	 * @param a
	 * @return
	 */
	private static int removeDuplicates4(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return 0;
		}
		
		int pre = a[0];
		boolean flag = false;
		int count = 0;
		
		for (int i = 1; i < a.length; i++) {
			int cur = a[i];
			if (pre == cur) {
				if (!flag) {
					flag = true;
					continue;
				} else {
					count++;
				}
			} else {
				flag = false;
			}
			pre = cur;
		}
		return a.length - count;
	}

	/**
	 * only return the allowed number of the array
	 * @param a
	 * @return
	 */
	private static int removeDuplicates3(int[] a) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		while (i < a.length - 1) {
			if (a[i] == a[i + 1]) {
				j++;
			}
			i++;
		}
		return a.length - j;
	}

	/**
	 * return the new array containing the unique elements
	 * @param a
	 * @return
	 */
	private static int[] removeDuplicates2(int[] a) {
		// TODO Auto-generated method stub
		int i = 1; 
		int j = 0;
		while (i < a.length) {
			if (a[i] == a[j]) {
				i++;
			} else {
				j++;
				a[j] = a[i];
				i++;
			}
		}
		int[] newArrasy = Arrays.copyOf(a, j + 1);
		return newArrasy;
	}

	/**
	 * only return the number of the unique elements
	 * @param a
	 * @return
	 */
	private static int removeDuplicates1(int[] a) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = 0;
		while (i < a.length) {
			if (a[i] == a[j]) {
				i++;
			} else {
				j++;
				a[j] = a[i];
				i++;
			}
		}
		printArray(a);
		return j + 1;
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
