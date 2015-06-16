package codingInterview;

public class SearchIn2DMat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int target = 4;
		// boolean isExisted = findValue(mat, target);
		boolean isExisted = binarySearch(mat, target);
		System.out.println(isExisted);

	}

	/**
	 * binary search
	 * 
	 * @param mat
	 * @param target
	 * @return
	 */
	private static boolean binarySearch(int[][] mat, int target) {
		// TODO Auto-generated method stub
		if (mat == null || mat.length == 0 || mat[0].length == 0) {
			return false;
		}
		int m = mat.length;
		int n = mat[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / n;
			int midY = mid % n;
			if (mat[midX][midY] == target) {
				return true;
			} else if (mat[midX][midY] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	/**
	 * naive approach
	 * 
	 * @param mat
	 * @param target
	 * @return
	 */
	private static boolean findValue(int[][] mat, int target) {
		// TODO Auto-generated method stub
		if (mat == null) {
			return false;
		}
		int m = mat.length;
		int n = mat[0].length;
		if (m == 0 && n == 0) {
			return false;
		}
		for (int i = 0; i < m - 1; i++) {
			if (mat[i][0] <= target && mat[i + 1][0] > target) {
				for (int j = 0; j < n; j++) {
					if (mat[i][j] == target) {
						return true;
					}
				}
			}
		}
		if (mat[m - 1][0] <= target) {
			for (int j = 0; j < n; j++) {
				if (mat[m - 1][j] == target) {
					return true;
				}
			}
		}
		return false;
	}

}
