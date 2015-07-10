package codingInterview;

public class MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 5, -5, 2, -2};
		int max = maxProductSubarray(a);
		System.out.println(max);

	}

	/**
	 * dynamic programming
	 * use max,min to handle the positive and negative sign effects
	 * @param a
	 * @return
	 */
	private static int maxProductSubarray(int[] a) {
		// TODO Auto-generated method stub
		int min = a[0];
		int max = a[0];
		int global = a[0];
		for (int i = 1; i < a.length; i++) {
			int tmp = max;
			max = Math.max(Math.max(a[i] * max, a[i]), a[i] * min);
			min = Math.min(Math.min(a[i] * min, a[i]), a[i] * tmp);
			global = Math.max(max, global);
		}
		return global;
	}

}
