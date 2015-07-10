package codingInterview;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2, 1, -3, 4, -1, 2, 1, 5, 4};
		int maxSubarray = maxSubarray(a, a.length);
		System.out.println(maxSubarray);

	}

	/**
	 *  dynamic programming
	 *  changing condition : ignore the sum of the previous n-1 elements 
	 *  if the nth element is greater than the sum.
	 * @param a
	 * @param length
	 * @return
	 */
	private static int maxSubarray(int[] a, int length) {
		// TODO Auto-generated method stub
		int maxSum = a[0];
		int sum = a[0];
		for (int i = 1; i < length; i++) {
			sum += a[i];
			if (a[i] > maxSum) {
				sum = a[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

}
