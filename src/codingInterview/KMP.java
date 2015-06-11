package codingInterview;

import java.util.ArrayList;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "haldgabcadabcabaabcdabcdgabcdldkabgcagagabcadabcabagcdabcjdlkgcabcdabcdgabcdagagagg";
		String pat = "abcadabcab";
		ArrayList<Integer> list = KMPSearch(text, pat);
		if (!list.isEmpty()) {
			for (int i : list) {
				System.out.println(i + " >>> "
						+ text.substring(i, i + pat.length()));
			}
		} else {
			System.out.println("no match");
		}

	}

	private static ArrayList<Integer> KMPSearch(String text, String pat) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int textLen = text.length();
		int patLen = pat.length();
		int[] nextTable = genNextTable(pat);

		printTalbe(pat, nextTable);

		int i = 0, j = 0;
		while (i < textLen) {
			while (j > -1 && text.charAt(i) != pat.charAt(j)) {
				j = nextTable[j];
			}
			i++;
			j++;
			if (j >= patLen) {
				list.add(i - patLen);
				j = 0;
			}
		}
		return list;
	}

	private static void printTalbe(String pat, int[] nextTable) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pat.length(); i++) {
			System.out.print(" " + pat.charAt(i));
		}
		System.out.println();
		for (int i : nextTable) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] genNextTable(String pat) {
		// TODO Auto-generated method stub
		int patLen = pat.length();
		int[] nextTable = new int[patLen];
		int j = nextTable[0] = -1;
		int i = 0;
		while (i < patLen - 1) {
			while (j > -1 && pat.charAt(i) != pat.charAt(j)) {
				j = nextTable[j];
			}
			i++;
			j++;
			if (pat.charAt(i) == pat.charAt(j)) {
				nextTable[i] = nextTable[j];
			} else {
				nextTable[i] = j;
			}
		}
		return nextTable;
	}

}
