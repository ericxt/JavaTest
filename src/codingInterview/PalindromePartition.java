package codingInterview;

import java.util.ArrayList;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaa";
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		result = deptFirstPartition(str);
		System.out.println(result);

		ArrayList<String> list = dynamicProgramPartition(str);
		System.out.println(list);

	}

	/**
	 * dynamic programming
	 * 
	 * @param str
	 * @return
	 */
	private static ArrayList<String> dynamicProgramPartition(String str) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		int[][] table = new int[str.length()][str.length()];
		if (str == null || str.length() == 0) {
			return result;
		}
		for (int l = 1; l < str.length() + 1; l++) {
			// pay attention to the value of j, not beyond the index of right
			// boundry
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j)) {
					if (l == 1 || l == 2) {
						table[i][j] = 1;
					} else {
						table[i][j] = table[i + 1][j - 1];
					}
					if (table[i][j] == 1) {
						result.add(str.substring(i, j + 1));
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		return result;
	}

	/**
	 * depth-first partition the string into parts, and each part should be a
	 * palindrome
	 * 
	 * @param str
	 * @return
	 */
	private static ArrayList<ArrayList<String>> deptFirstPartition(String str) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (str == null || str.length() == 0)
			return result;
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(str, 0, partition, result);
		return result;
	}

	/**
	 * recursion
	 * 
	 * @param str
	 * @param start
	 * @param partition
	 * @param result
	 */
	private static void addPalindrome(String str, int start,
			ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
		// TODO Auto-generated method stub
		if (start == str.length()) {
			// System.out.println("end");
			ArrayList<String> tmp = new ArrayList<>(partition);
			result.add(tmp);
			return;
		}

		for (int i = start + 1; i < str.length() + 1; i++) {
			String substr = str.substring(start, i);
			if (isPalindrome(substr)) {
				// System.out.println("in >>> " + i + ", " + start);
				partition.add(substr);
				addPalindrome(str, i, partition, result);
				// System.out.println("out >>> " + i + ", " + start);
				partition.remove(partition.size() - 1);
			}
		}

	}

	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
