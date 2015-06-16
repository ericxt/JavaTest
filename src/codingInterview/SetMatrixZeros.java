package codingInterview;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[5][4];
		int m = 4, n = 4;
		int value = -1;
		initiateMat(mat, m, n, value);
		mat[1][2] = 0;
		mat[3][3] = 0;
		printMat(mat, m, n);
		setZero(mat, m, n);
		printMat(mat, m, n);

	}

	private static void initiateMat(int[][] mat, int m, int n, int value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = value;
			}
		}
		
	}

	private static void setZero(int[][] mat, int m, int n) {
		// TODO Auto-generated method stub
		
		
	}

	private static void printMat(int[][] mat, int m, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(j == n - 1 ? mat[i][j] + "\n" : mat[i][j] + " ");
			}
		}
		System.out.println("------------------");
	}

}
