package codingInterview;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3 }, 
						{ 4, 5, 6 }, 
						{ 7, 8, 9 }, 
						{ 10, 11, 12 } };
		ArrayList<Integer> result = spiralOrder(mat);
		printMat(result);
		result = spiralRecursively(mat);
		printMat(result);
	}

	/**
	 * recursively
	 * 
	 * @param mat
	 * @return
	 */
	private static ArrayList<Integer> spiralRecursively(int[][] mat) {
		// TODO Auto-generated method stub
		if (mat == null) {
			return null;
		}

		return spiralRecursively(mat, 0, 0, mat.length, mat[0].length);
	}

	private static ArrayList<Integer> spiralRecursively(int[][] mat, int x,
			int y, int m, int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (m <= 0 || n <= 0) {
			return result;
		}

		if (m == 1) {
			for (int i = 0; i < n; i++) {
				result.add(mat[x][y++]);
			}
			return result;
		} else if (n == 1) {
			for (int i = 0; i < m; i++) {
				result.add(mat[x++][y]);
			}
			return result;
		}

		for (int i = 0; i < n - 1; i++) {
			result.add(mat[x][y++]);
		}
		for (int i = 0; i < m - 1; i++) {
			result.add(mat[x++][y]);
		}
		for (int i = 0; i < n - 1; i++) {
			result.add(mat[x][y--]);
		}
		for (int i = 0; i < m - 1; i++) {
			result.add(mat[x--][y]);
		}

		if (m == 1 || n == 1) {
			result.addAll(spiralRecursively(mat, x + 1, y + 1, m, n));
		} else {
			result.addAll(spiralRecursively(mat, x + 1, y + 1, m - 2, n - 2));
		}
		return result;
	}

	private static void printMat(ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		if (result == null) {
			System.out.println("null");
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * handle the matrix like a circle
	 * 
	 * @param mat
	 * @return
	 */
	private static ArrayList<Integer> spiralOrder(int[][] mat) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (mat == null) {
			return null;
		}
		int m = mat.length, n = mat[0].length;
		int x = 0, y = 0;
		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(mat[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(mat[x++][y]);
				}
				break;
			}

			for (int i = 0; i < n - 1; i++) {
				result.add(mat[x][y++]);
			}
			for (int i = 0; i < m - 1; i++) {
				result.add(mat[x++][y]);
			}
			for (int i = 0; i < n - 1; i++) {
				result.add(mat[x][y--]);
			}
			for (int i = 0; i < m - 1; i++) {
				result.add(mat[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}
		return result;
	}
}
