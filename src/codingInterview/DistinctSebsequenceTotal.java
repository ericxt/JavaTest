package codingInterview;

public class DistinctSebsequenceTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit";
		String t = "rabit";

		int total = distinctSubsequenceTotal(s, t);
		System.out.println(total);

	}

	// dynamic programming : pay attention to the changing condition
	private static int distinctSubsequenceTotal(String s, String t) {
		// TODO Auto-generated method stub
		int[][] table = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < t.length() + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					table[i][j] += table[i - 1][j - 1] + table[i - 1][j];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}
		printTable(table, s.length() + 1, t.length() + 1);
		return table[s.length()][t.length()];
	}

	private static void printTable(int[][] table, int m, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(table[i][j]);
			}
		}
		System.out.println();
		
	}

}
