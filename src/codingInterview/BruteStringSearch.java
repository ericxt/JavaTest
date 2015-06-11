package codingInterview;

public class BruteStringSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "adgaldkgoodpattrnkadhg;jad";
		String pat = "goodpattern";
		int pos = -1;
		pos = bruteStrSearch1(str, pat);

		pos = bruteStrSearch2(str, pat);
		if (pos >= 0)
			System.out.println("pos = " + pos + " >>> "
					+ str.substring(pos, pos + pat.length()));
		else
			System.out.println("pos = " + pos);
		
		// efficiency test
		// for bruteStrSearch1
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			bruteStrSearch1(str, pat);
		}
		long endTime = System.nanoTime();
		System.out.println("bruteStrSearch1 cost time : " + (endTime - startTime));
		
		// for bruteStrSearch2
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			bruteStrSearch2(str, pat);
		}
		endTime = System.nanoTime();
		System.out.println("bruteStrSearch2 cost time : " + (endTime - startTime));

	}

	private static int bruteStrSearch2(String str, String pat) {
		// TODO Auto-generated method stub
		int strLen = str.length();
		int patLen = pat.length();
		int i, j;
		for (i = 0, j = 0; i < strLen && j < patLen; i++) {
			if (str.charAt(i) == pat.charAt(j)) {
				j++;
			} else {
				i -= j;
				j = 0;
			}
		}
		if (j == patLen)
			return i - patLen;
		else
			return -1;
	}

	private static int bruteStrSearch1(String str, String pat) {
		// TODO Auto-generated method stub
		int strLen = str.length();
		int patLen = pat.length();

		for (int i = 0; i <= strLen - patLen; i++) {
			for (int j = 0; j < patLen; j++) {
				// System.out.print(str.charAt(i + j) + " >>> " + pat.charAt(j)
				// + " ");
				// System.out.print(j + " : " + patLen);
				// System.out.println();
				if (str.charAt(i + j) != pat.charAt(j)) {
					break;
				}
				if (j == patLen - 1)
					return i;
			}
		}
		return -1;
	}

}
