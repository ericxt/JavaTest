package codingInterview;

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hayStack = "hakdhgkgoodadlkg";
		String needle = null;
		String subString = findStr(hayStack, needle);
		System.out.println(subString == null ? "not found"
				: "found, subString : " + subString);
	}

	private static String findStr(String hayStack, String needle) {
		// TODO Auto-generated method stub
		if (hayStack == null || needle == null) {
			return null;
		}
		int hayStackLen = hayStack.length();
		int needleLen = needle.length();
		if (hayStackLen == needleLen && needleLen == 0) {
			return "";
		}
		if (needleLen == 0) {
			return hayStack;
		}
		for (int i = 0; i < hayStackLen; i++) {
			if (hayStackLen - i + 1 < needleLen) {
				return null;
			}
			int k = i;
			int j = 0;
			while (j < needleLen && k < hayStackLen
					&& hayStack.charAt(k) == needle.charAt(j)) {
				j++;
				k++;
				if (j >= needleLen) {
					return hayStack.substring(i);
				}
			}
		}
		return null;
	}

}
