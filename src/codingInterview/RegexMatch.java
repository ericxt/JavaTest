package codingInterview;

public class RegexMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a";
		String pat = ".*";
		boolean isMatch = isMatch(str, pat);
		System.out.println(isMatch);
	}

	// classify the cases
	private static boolean isMatch(String str, String pat) {
		// TODO Auto-generated method stub
		// base case
		if (pat.length() == 0) {
			return str.length() == 0;
		}

		// special case
		if (pat.length() == 1) {
			if (str.length() < 1) {
				return false;
			} else if (str.charAt(0) != pat.charAt(0) && pat.charAt(0) != '.') {
				return false;
			} else {
				return isMatch(str.substring(1), pat.substring(1));
			}
		}

		if (pat.charAt(1) != '*') {
			if (str.length() < 1) {
				return false;
			} else if (str.charAt(0) != pat.charAt(0) && pat.charAt(0) != '.') {
				return false;
			} else {
				return isMatch(str.substring(1), pat.substring(1));
			}
		} else {
			if (isMatch(str, pat.substring(2))) {
				return true;
			}

			int i = 0;
			while (i < str.length()
					&& (str.charAt(i) == pat.charAt(0) || pat.charAt(0) == '.')) {
				if (isMatch(str.substring(i + 1), pat.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
}
