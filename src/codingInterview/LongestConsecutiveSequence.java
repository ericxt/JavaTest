package codingInterview;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 3, 5, 9, 7, 2 };
		
		int longestSequence = LongestSequence(array);
		System.out.println(longestSequence);
		
//		long startTime = System.nanoTime();
//		for (int i = 0; i < 10000; i++) {
//			LongestSequence(array);
//		}
//		long endTime = System.nanoTime();
//		System.out.println("LongestSequence        >>> cost time : "
//				+ (endTime - startTime));
//		
//		startTime = System.nanoTime();
//		for (int i = 0; i < 10000; i++) {
//			LongestSequenceWithMap(array);
//		}
//		endTime = System.nanoTime();
//		System.out.println("LongestSequenceWithMap >>> cost time : "
//				+ (endTime - startTime));

	}

	/**
	 * O(n)
	 * 
	 * @param array
	 * @return
	 */
	private static int LongestSequenceWithMap(int[] array) {
		// TODO Auto-generated method stub
		if (array == null) {
			return -1;
		}
		int len = array.length;
		if (len == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int e : array) {
			set.add(e);
		}
		int max = -1;
		for (int e : array) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
	}

	/**
	 * O(n^2)
	 * 
	 * @param array
	 * @return
	 */
	private static int LongestSequence(int[] array) {
		// TODO Auto-generated method stub
		if (array == null) {
			return -1;
		}
		Arrays.sort(array);
		int len = array.length;
//		for (int i = 0; i < len; i++) {
//			System.out.print(array[i] + " ");
//		}
//		System.out.println();
		if (len == 0)
			return 0;

		int max = -1;
		for (int i = 0; i < len; i++) {
			int j = i;
			int count = 1;
			while (j < len - 1) {
				if (array[j + 1] - array[j] == 1) {
					count++;
					j++;
				} else {
					break;
				}
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}

}
