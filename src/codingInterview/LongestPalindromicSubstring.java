package codingInterview;

import java.util.Arrays;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "kafgdkhgfkdhgfagooboyisdsiyoboogahadsjklghalksdhgka";
		str = "bb";
		String subString = null;
		// subString = longestPalindrome1(str);
		// subString = longestPalindrome2(str);
//		subString = longestPalindrome3(str);
//		System.out.println(subString);
		subString = longestPalindrome4(str);
		System.out.println(subString);

		// efficiency test
		// for naive method
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			longestPalindrome1(str);
		}
		long endTime = System.nanoTime();
		System.out.println(" longestPalindrome1 cost time : "
				+ (endTime - startTime));

		// for dynamic programming
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			longestPalindrome2(str);
		}
		endTime = System.nanoTime();
		System.out.println(" longestPalindrome2 cost time : "
				+ (endTime - startTime));

		// for simple alg.
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			longestPalindrome3(str);
		}
		endTime = System.nanoTime();
		System.out.println(" longestPalindrome3 cost time : "
				+ (endTime - startTime));
		
		// for manacher alg.
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			longestPalindrome4(str);
		}
		endTime = System.nanoTime();
		System.out.println(" longestPalindrome4 cost time : "
				+ (endTime - startTime));
	}

	/**
	 * Manacher alg.
	 * 
	 * @param str
	 * @return
	 */
	private static String longestPalindrome4(String str) {
		// TODO Auto-generated method stub
		int length = str.length();
		int rightBoundary = -1, center = -1;
		int maxPos = 0, maxValue = 0;
		;

		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			strBuilder.append("#");
			strBuilder.append(str.charAt(i));
		}
		strBuilder.append("#");
//		System.out.println(strBuilder);

		int[] palindrLen = new int[strBuilder.length()];

		for (int i = 0; i < strBuilder.length(); i++) {
			if (i > rightBoundary) {
				palindrLen[i] = 0;
			} else if (rightBoundary >= i) {
				palindrLen[i] = Math.min(palindrLen[2 * center - i],
						rightBoundary - i);
			}

			while (i - palindrLen[i] - 1 >= 0
					&& i + palindrLen[i] + 1 <= strBuilder.length() - 1
					&& strBuilder.charAt(i - palindrLen[i] - 1) == strBuilder
							.charAt(i + palindrLen[i] + 1)) {
				palindrLen[i]++;
			}

			if (palindrLen[i] > maxValue) {
				maxPos = i;
				maxValue = palindrLen[i];
			}

			if (i + palindrLen[i] > rightBoundary) {
				rightBoundary = i + palindrLen[i];
				center = i;
			}
		}

		// for (int val : palindrLen) {
		// System.out.print(val);
		// }
		// System.out.println();
		return str.substring((maxPos - maxValue) / 2, (maxPos - maxValue) / 2 + maxValue);
	}

	/**
	 * O(n^2) time, O(1) space
	 * 
	 * @param str
	 * @return
	 */
	private static String longestPalindrome3(String str) {
		// TODO Auto-generated method stub
		if (str.isEmpty())
			return null;
		if (str.length() == 1) {
			return str;
		}

		String longestPalindr = str.substring(0, 1);
		for (int i = 0; i < str.length(); i++) {
			String tmp = helper(str, i, i);
			if (tmp.length() > longestPalindr.length()) {
				longestPalindr = tmp;
			}

			tmp = helper(str, i, i + 1);
			if (tmp.length() > longestPalindr.length()) {
				longestPalindr = tmp;
			}
		}
		return longestPalindr;
	}

	private static String helper(String str, int start, int end) {
		// TODO Auto-generated method stub
		while (start >= 0 && end <= str.length() - 1
				&& str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		return str.substring(start + 1, end);
	}

	/**
	 * dynamic programming O(n^2)
	 * 
	 * @param str
	 * @return
	 */
	private static String longestPalindrome2(String str) {
		// TODO Auto-generated method stub
		int maxPalindr = 0;
		String longestPalindr = null;
		int length = str.length();
		int[][] table = new int[length][length];

		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		// printTable(table);

		for (int i = 0; i < length - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = 1;
			}
		}
		// printTable(table);

		for (int l = 3; l <= length; l++) {
			for (int i = 0, j = i + l - 1; i < length && j < length; i++, j++) {
				if (str.charAt(i) == str.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxPalindr) {
						maxPalindr = l;
						longestPalindr = str.substring(i, j + 1);
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		// printTable(table);

		return longestPalindr;
	}

	private static void printTable(int[][] table) {
		// TODO Auto-generated method stub
		for (int[] x : table) {
			for (int value : x) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");

	}

	/**
	 * naive method : O(n^3)
	 * 
	 * @param str
	 * @return
	 */
	private static String longestPalindrome1(String str) {
		// TODO Auto-generated method stub
		int maxPalindr = 0;
		String longestPalindr = null;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int curLen = j - i;
				String curStr = str.substring(i, j + 1);
				if (isPalindrome(curStr)) {
					if (curLen > maxPalindr) {
						maxPalindr = curLen;
						longestPalindr = curStr;
					}
				}
			}
		}
		return longestPalindr;
	}

	private static boolean isPalindrome(String curStr) {
		// TODO Auto-generated method stub
		int length = curStr.length();
		for (int i = 0; i < length; i++) {
			if (curStr.charAt(i) != curStr.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
