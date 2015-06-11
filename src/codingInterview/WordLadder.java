package codingInterview;

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
//		String start = "a";
//		String end = "c";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("lot");
		dict.add("dot");
//		dict.add("dog");
//		dict.add("log");
//		dict.add("a");
//		dict.add("b");
//		dict.add("c");
//		int len = naiveWordLadder(start, end, dict);
		int len = bfsWordLadder(start, end, dict);
		System.out.println(len);
	}

	/**
	 * breadth first search
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	private static int bfsWordLadder(String start, String end,
			HashSet<String> dict) {
		// TODO Auto-generated method stub
		if (dict.isEmpty()) {
			return -1;
		}
		dict.add(end);
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distQueue = new LinkedList<Integer>();
		wordQueue.add(start);
		distQueue.add(1);
		int result = Integer.MAX_VALUE;
		
		while (!wordQueue.isEmpty()) {
			String curWord = wordQueue.pop();
			Integer curDist = distQueue.pop();
			if (curWord.equals(end)) {
				return Math.min(result, curDist);
			}
			
			for (int i = 0; i < curWord.length(); i++) {
				char[] curWordArray = curWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == curWordArray[i])
						continue;
					
					curWordArray[i] = c;
					String tmp = new String(curWordArray);
					if (dict.contains(tmp)) {
						wordQueue.add(tmp);
						distQueue.add(curDist + 1);
						dict.remove(tmp);
					}
				}
			}
		}
		
		if (result < Integer.MAX_VALUE) {
			return result;
		} else {
			return -1;
		}
	}

	/**
	 * can not find optimal path
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	private static int naiveWordLadder(String start, String end,
			HashSet<String> dict) {
		// TODO Auto-generated method stub
		int len = 0;
		dict.add(end);
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < start.length(); i++) {
			char[] array = start.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == start.charAt(i)) {
					continue;
				}
				array[i] = c;
				String temp = new String(array);
//				System.out.println(temp);
				if (dict.contains(temp)) {
					len++;
					i = -1;
					visited.add(temp);
					dict.remove(temp);
					System.out.println(len + ", " + temp);
					start = temp;
					if (start.equals(end)) {
						return len;
					}
					break;
				}
			}
		}
		return -1;
	}

}
