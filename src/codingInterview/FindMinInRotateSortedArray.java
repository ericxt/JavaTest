package codingInterview;

public class FindMinInRotateSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 3, 4, 1, 3, 3, 3 };
		// int min = findMin(a);
		// System.out.println(min);

		int min = findMinWithDup(a);
		System.out.println(min);

	}

	/**
	 * suppose to be non-decreasing with duplicates
	 * 
	 * @param a
	 * @return
	 */
	private static int findMinWithDup(int[] a) {
		// TODO Auto-generated method stub
		return findMinWithDup(a, 0, a.length - 1);
	}

	private static int findMinWithDup(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return -1;
		}

		if (left == right) {
			return a[left];
		}
		if (a[left] < a[right]) {
			return a[left];
		}
		if (right - left == 1) {
			return Math.min(a[left], a[right]);
		}

		int mid = (left + right) / 2;
		if (a[left] == a[right]) {
			return findMinWithDup(a, left + 1, right);
		} else if (a[left] < a[mid]) {
			System.out.println(mid + ", " + a[mid]);
			return findMinWithDup(a, mid, right);
		} else {
			System.out.println(mid + ", " + a[mid]);
			return findMinWithDup(a, left, mid);
		}
	}

	/**
	 * suppose to be non-decreasing without duplicates
	 * 
	 * @param a
	 * @return
	 */
	private static int findMin(int[] a) {
		// TODO Auto-generated method stub
		return findMin(a, 0, a.length - 1);
	}

	private static int findMin(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if (a[left] < a[right]) {
			return a[left];
		}

		if (right - left == 1) {
			return Math.min(a[left], a[right]);
		}

		int mid = (right + left) / 2;
		System.out.println(mid + ", " + a[mid]);

		if (a[left] < a[mid]) {
			return findMin(a, mid, right);
		} else {
			return findMin(a, left, mid);
		}
	}
}
