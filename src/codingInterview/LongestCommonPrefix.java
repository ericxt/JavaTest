package codingInterview;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"predlgas", "preskdlf;", "prekdsg", "prekdkgl;", "predlldf"};
		String prefix = longestCommonPrefix(strs);
		System.out.println(prefix);

	}

	private static String longestCommonPrefix(String[] strs) {
		// TODO Auto-generated method stub
		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for (String str : strs) {
			if (minLen > str.length()) {
				minLen = str.length();
			}
		}
		if (minLen == 0) {
			return "";
		}
		for (int j = 0; j < minLen; j++) {
			char prev = '0';
			for (int i = 0; i < strs.length; i++) {
				if (i == 0) {
					prev = strs[i].charAt(j);
					continue;
				}
				if (prev != strs[i].charAt(j)) {
					return strs[i].substring(0, j);
				}
			}
		}
		return strs[0].substring(0, minLen);
	}

}
