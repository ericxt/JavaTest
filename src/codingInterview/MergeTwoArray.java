package codingInterview;

public class MergeTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[100];
		a[0] = 1;
		for (int i = 1; i < 5; i++) {
			a[i] = a[i - 1] + 2;
		}

		int[] b = { -1, 2, 4, 6, 8, 10 };
		int m = 5, n = 6;
		// naiveMergeSortedArray(a, m, b, n);
		// mergeSortedArray(a, m, b, n);
		mergeArray(a, m, b, n);
		for (int i = 0; i < m + n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * much shorter
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 */
	private static void mergeArray(int[] a, int m, int[] b, int n) {
		// TODO Auto-generated method stub
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || (i >= 0 && a[i] >= b[j])) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}

	}

	/**
	 * from right to left , avoid moving array a
	 * 
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 */
	private static void mergeSortedArray(int[] a, int m, int[] b, int n) {
		// TODO Auto-generated method stub
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (a[i - 1] >= b[j - 1]) {
				a[i + j - 1] = a[i - 1];
				i--;
			} else {
				a[i + j - 1] = b[j - 1];
				j--;
			}
		}
		while (j > 0) {
			a[j - 1] = b[j - 1];
			j--;
		}

	}

	/**
	 * from left to right, expand the length of array a, cost too much
	 * 
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 */
	private static void naiveMergeSortedArray(int[] a, int m, int[] b, int n) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k = 0;
		while (k < m && j < n) {
			if (a[i] <= b[j]) {
				i++;
				k++;
			} else {
				move(a, i, m + j + 1);
				a[i] = b[j];
				System.out.println("after move");
				for (int l = 0; l < m + j + 1; l++) {
					System.out.print(a[l] + " ");
				}
				System.out.println();
				System.out.println("i : " + i + ", " + "j : " + j);
				i++;
				j++;
			}
		}

		while (j < n) {
			a[m + j] = b[j];
			j++;
		}
	}

	private static void move(int[] a, int i, int upBound) {
		// TODO Auto-generated method stub
		int j = upBound;
		while (j > i) {
			a[j] = a[j - 1];
			j--;
		}

	}

}
