package codingInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordSet = new HashSet<String>();
		wordSet.add("leet");
		wordSet.add("code");
		wordSet.add("people's");
		wordSet.add("programcree");
		wordSet.add("republic");
		wordSet.add("of");
		wordSet.add("China");
		wordSet.add("program");
		wordSet.add("creek");
		wordSet.add("cats");
		wordSet.add("cat");
		wordSet.add("and");
		wordSet.add("sand");
		wordSet.add("dog");
		wordSet.add("do");
		String str = "catsanddog";

		// ArrayList<String> segmented = naiveWordBreak(str, wordSet);
		List<String> segmented = DPWordBreak(str, wordSet);
		System.out.println(segmented);
		// boolean canSegmented = dynamicProgramWordBreak(str, wordSet);
		// System.out.println(canSegmented);
		// canSegmented = patternWordBreak(str, wordSet);
		// System.out.println(canSegmented);

	}

	private static List<String> DPWordBreak(String str, Set<String> wordSet) {
		// TODO Auto-generated method stub
		int strLen = str.length();
		ArrayList<String>[] dpTable = new ArrayList[strLen + 1];
		dpTable[0] = new ArrayList<String>();

		for (int i = 0; i < strLen; i++) {
			if (dpTable[i] == null)
				continue;

			for (String word : wordSet) {
				int wordLen = word.length();
				int end = i + wordLen;
				if (end > strLen)
					continue;

				if (str.substring(i, end).equals(word)) {
					if (dpTable[end] == null)
						dpTable[end] = new ArrayList<String>();
					dpTable[end].add(word);
				}
			}
		}

		LinkedList<String> result = new LinkedList<String>();
		if (dpTable[strLen] == null) {
			return result;
		}
		dfs(dpTable, strLen, result);
		return result;
	}

	private static void dfs(ArrayList<String>[] dpTable, int strLen,
			LinkedList<String> result) {
		// TODO Auto-generated method stub
		if (strLen <= 0) {
			return;
		}
		for (String word : dpTable[strLen]) {
			result.add(strLen + word);
			dfs(dpTable, strLen - word.length(), result);
		}

	}

	private static boolean patternWordBreak(String str, Set<String> wordSet) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (String word : wordSet) {
			sb.append(word).append("|");
		}
		sb.insert(0, "(");
		sb.insert(sb.length() - 1, ")*");
		String pattern = sb.substring(0, sb.length() - 1).toString();
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}

	private static boolean dynamicProgramWordBreak(String str,
			Set<String> wordSet) {
		// TODO Auto-generated method stub
		int strLen = str.length();
		boolean[] segTable = new boolean[strLen + 1];
		segTable[0] = true;
		for (int i = 0; i < strLen; i++) {
			System.out.println(i + ":--------------------------");
			if (!segTable[i])
				continue;

			for (String word : wordSet) {
				System.out.println(word);
				int wordLen = word.length();
				int end = i + wordLen;
				if (end > strLen)
					continue;
				if (str.substring(i, end).equals(word)) {
					segTable[end] = true;
					System.out.print(str.substring(i, end));
					System.out.println(" seg[" + end + "] >>> " + segTable[i]);
				}
			}
		}
		return segTable[str.length()];
	}

	private static ArrayList<String> naiveWordBreak(String str,
			Set<String> wordSet) {
		// TODO Auto-generated method stub
		return naiveWordBreakHelper(str, wordSet, 0);
	}

	// O(n^2)
	// find out all the matched arrays
	private static ArrayList<String> naiveWordBreakHelper(String str,
			Set<String> wordSet, int start) {
		// TODO Auto-generated method stub
		ArrayList<String> segmented = new ArrayList<String>();
		boolean canSegmented = false;
		if (start == str.length()) {
			canSegmented = true;
			return segmented;
		}

		for (String word : wordSet) {
			int wordLen = word.length();
			int end = start + wordLen;
			// System.out.println("end >>> " + end);

			// System.out.println(word);
			if (end > str.length()) {
				// System.out.println(word + " end > str.length");
				canSegmented = false;
				continue;
			}

			// System.out.println("word >>> " + word + ", substring >>> " +
			// str.substring(start, end));
			if (str.substring(start, end).equals(word)) {
				segmented.add(word);
				System.out.println("start >>> " + start);
				System.out.println("after equal : " + word);
				System.out.println("segmented : " + segmented);
				ArrayList<String> tmp = naiveWordBreakHelper(str, wordSet, end);
				System.out.println("tmp >>> " + tmp);
				if (tmp != null) {
					canSegmented = true;
					segmented.addAll(tmp);
					System.out.println("seg >>> " + segmented + ", start >>> "
							+ start);
				}

				if (end == str.length()) {
					System.out.println("break");
					break;
				}
			}
		}

		if (canSegmented)
			return segmented;
		else
			return null;
	}
}
