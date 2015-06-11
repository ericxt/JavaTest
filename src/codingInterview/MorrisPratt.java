package codingInterview;

import java.util.ArrayList;

public class MorrisPratt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "hadlglgoodgoodboyalgcagagagoodgoodgkabaddglkadl";
		String pat = "goodgood";
		int offset = -1;

//		offset = morrisPratt(text, pat);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = morrisPratt2(text, pat);
		for (int i : list) {
			System.out.println(i + " " + text.substring(i, i + pat.length()));
		}
		System.out.println();

		if (offset == -1) {
			System.out.println("no match");
		} else {
			System.out.println("offset = " + offset);
			System.out.println(text);
			for (int i = 0; i < offset; i++) {
				System.out.print(" ");
			}
			System.out.println(pat);
		}

	}

	private static ArrayList<Integer> morrisPratt2(String text, String pat) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int textLen = text.length();
		int patLen = pat.length();
		int[] nextTable = new int[patLen];
		int i = 0, j = 0;
		nextTable = genNextTable(pat);
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

	private static int morrisPratt(String text, String pat) {
		// TODO Auto-generated method stub
		int textLen = text.length();
		int patLen = pat.length();
		int[] nextTable = new int[patLen];
		nextTable = genNextTable(pat);
		printPatTable(pat, nextTable);
		int i = 0, j = 0;
		while (i < textLen) {
			while (j > -1 && text.charAt(i) != pat.charAt(j)) {
				j = nextTable[j];
			}
			i++;
			j++;
			if (j >= patLen) {
				return i - patLen;
			}
		}
		return -1;
	}

	private static void printPatTable(String pat, int[] nextTable) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pat.length(); i++) {
			System.out.print(" " + pat.charAt(i));
		}
		System.out.println();
		for (int i = 0; i < nextTable.length; i++) {
			System.out.print(nextTable[i] + " ");
		}
		System.out.println();

	}

	private static int[] genNextTable(String pat) {
		// TODO Auto-generated method stub
		int patLen = pat.length();
		int[] nextTable = new int[patLen];
		nextTable[0] = -1;
		int i = 0;
		int j = nextTable[0];
		while (i < patLen - 1) {
//			System.out.println("i = " + i + ", j = " + j + " >>> [" + i
//					+ "] = " + nextTable[i]);
			while (j > -1 && pat.charAt(i) != pat.charAt(j)) {
				j = nextTable[j];
//				System.out.println("i = " + i + ", j = " + j + " >>> [" + i
//						+ "] = " + nextTable[i]);
			}
			nextTable[++i] = ++j;
		}
		return nextTable;
	}

}
