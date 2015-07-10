package codingInterview;

import java.util.HashMap;
import java.util.Map.Entry;


public class LongestSubstringUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcbbbbcccbdddadacb";
//		int count = lenOfLongestSubstr1(str);
//		System.out.println(count);
		
//		int count = lenOfLongestSubstr2(str);
//		System.out.println(count);
		
//		String maxSubstring = maxSubstr2UniqueChars(str);
//		System.out.println(maxSubstring);
		
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
		String maxSubstring = maxSubstrNUniqueChars1(str, 3);
		}
		long endTime = System.nanoTime();
		System.out.println("1 >>> " + (endTime - startTime));
//		System.out.println(maxSubstring);
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
		String maxSubstring = maxSubstrNUniqueChars2(str, 3);
		}
		endTime = System.nanoTime();
		System.out.println("2 >>> " + (endTime - startTime));
//		System.out.println(maxSubstring);

	}

	/**
	 * better approach
	 * Longest substring containing N unique characters
	 * time complexity : o(n)
	 * @param str
	 * @param i
	 * @return
	 */
	private static String maxSubstrNUniqueChars2(String str, int count) {
		// TODO Auto-generated method stub
		if (str == null || count == 0)
			return null;
		
		int start = 0, maxLen = 0;
		String maxSubstring = null;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			
			if (map.size() > count) {
				if (i - start > maxLen) {
					maxLen = i - start;
					maxSubstring = str.substring(start, i);
				}
				
				while (map.size() > count) {
					char first = str.charAt(start);
					if (map.get(first) > 1) {
						map.put(first, map.get(first) - 1);
					} else {
						map.remove(first);
					}
					start++;
				}
			}
		}
		
		if (map.size() == count && maxLen == 0) {
			return str;
		}
		return maxSubstring;
	}

	/**
	 * Longest substring containing N unique characters
	 * @param str
	 * @param count 
	 * @return
	 */
	private static String maxSubstrNUniqueChars1(String str, int count) {
		// TODO Auto-generated method stub
		if (str == null || count == 0)
			return null;
		
		int start = 0;
		int maxLen = 0;
		String maxSubstring = null;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			if (map.size() == count && !map.containsKey(str.charAt(i))) {
				if (i - start > maxLen) {
					maxLen = i - start;
					maxSubstring = str.substring(start, i);
				}
				int leftmost = str.length();
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < leftmost) {
						leftmost = entry.getValue();
					}
				}
				start = leftmost + 1;
				map.remove(str.charAt(leftmost));
			}
			
			map.put(str.charAt(i), i);
		}
		
		if (str.length() == count && maxLen == 0) {
			return str;
		}
		
		return maxSubstring;
	}

	/**
	 * Longest substring containing 2 unique characters
	 * time complexity : n(n*k)
	 * @param str
	 * @return
	 */
	private static String maxSubstr2UniqueChars(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.length() == 0)  {
			return str;
		}
		
		int maxLen = 0;
		String maxSubstring = null;
		int start = 0;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			if (map.size() == 2 && !map.containsKey(str.charAt(i))) {
				if (i - start > maxLen) {
					maxLen = i - start;
					maxSubstring = str.substring(start, i);
				}
				int leftmost = str.length();
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < leftmost) {
						leftmost = entry.getValue();
					}
				}
				start = leftmost + 1;
				map.remove(str.charAt(leftmost));
			}
			
			map.put(str.charAt(i), i);
		}
		if (str.length() == 2 && maxLen == 0) {
			return str;
		}
		return maxSubstring;
	}

	/**
	 * allowed to contain the unique character
	 * @param str
	 * @return
	 */
	private static int lenOfLongestSubstr2(String str) {
		// TODO Auto-generated method stub
		char[] array = str.toCharArray();
		// respecting to ascii
		boolean[] flag = new boolean[256];
		int result = 0;
		int start = 0;
		
		for (int i = 0; i < array.length; i++) {
			char cur = array[i];
			if (flag[cur]) {
				result = Math.max(result, i - start);
				for (int j = start; j < i; j++) {
					if (array[j] == cur) {
						start = j + 1;
						break;
					}
					flag[array[j]] = false;
				}
			} else {
				flag[cur] = true;
			}
		}
		return Math.max(result, array.length - start);
	}

	/**
	 * allowed to contain the unique character
	 * understandable, but the time complexity is higher
	 * @param str
	 * @return
	 */
	private static int lenOfLongestSubstr1(String str) {
		// TODO Auto-generated method stub
		char[] array = str.toCharArray();
		int maxLen = 0;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], i);
			} else {
				maxLen = Math.max(maxLen, map.size());
				map.clear();
			}
		}
		return Math.max(maxLen, map.size());
	}

}
