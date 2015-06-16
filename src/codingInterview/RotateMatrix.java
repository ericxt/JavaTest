package codingInterview;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMat(mat);
		// rotateMat(mat);
		rotateMatInPlace(mat);
		printMat(mat);

	}

	private static void rotateMatInPlace(int[][] mat) {
		// TODO Auto-generated method stub
		if (mat == null || mat.length == 0 || mat[0].length == 0) {
			System.out.println("can not rotate");
			return;
		}
		int n = mat.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - 1 - j][i];
				mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
				mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
				mat[j][n - 1 - i] = temp;
				System.out.println("i = " +  (i+1));
				printMat(mat);
			}
		}

	}

	private static void printMat(int[][] mat) {
		// TODO Auto-generated method stub
		if (mat == null) {
			System.out.println("null");
			return;
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.printf("%3s", j == mat[0].length - 1 ? mat[i][j] + "\n"
						: mat[i][j] + " ");
			}
		}
		System.out.println("------------");

	}

	private static void rotateMat(int[][] mat) {
		// TODO Auto-generated method stub
		if (mat == null || mat.length == 0 || mat[0].length == 0) {
			return;
		}

		int m = mat.length;
		int n = mat[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[j][m - 1 - i] = mat[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = result[i][j];
			}
		}

	}

}
