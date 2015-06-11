package codingInterview;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarpStrSearch {
	private String pat;
	private int patLen;
	private int radix;
	private long patHash;
	private long largePrime;
	private long RM; // radix * (patLen - 1) % largePrime

	public RabinKarpStrSearch(String pat) {
		// TODO Auto-generated constructor stub
		this.pat = pat;
		patLen = pat.length();
		radix = 256;
		largePrime = longRandomPrime();

		RM = 1;
		for (int i = 0; i < patLen; i++) {
			RM = (radix * RM) % largePrime;
		}

		patHash = hash(pat, 0, patLen);
	}

	private long hash(String string, int offset, int length) {
		// TODO Auto-generated method stub
		long h = 0;
		for (int i = 0; i < length; i++) {
			h = (h * radix + string.charAt(i + offset)) % largePrime;
		}
		return h;
	}

	private boolean check(String str, int offset) {
		for (int i = 0; i < patLen; i++) {
			if (str.charAt(offset + i) != pat.charAt(i))
				return false;
		}
		return true;
	}

	private int search(String str) {
		int strLen = str.length();
		long strHash = hash(str, 0, patLen);
		if (patHash == strHash && check(str, 0)) {
			return 0;
		}

		for (int i = patLen; i < strLen; i++) {
//			strHash = (strHash + largePrime - RM * str.charAt(i - patLen)
//					% largePrime)
//					% largePrime;
//			strHash = (strHash * radix + str.charAt(i)) % largePrime;

			int offset = i - patLen + 1;
			strHash = hash(str, offset, patLen);
			if (strHash == patHash && check(str, offset))
				return offset;
		}

		return -1;
	}

	private long longRandomPrime() {
		// TODO Auto-generated method stub
		BigInteger probablePrime = BigInteger.probablePrime(31, new Random());
		return probablePrime.longValue();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ahdkgagoodboyryobdoogaahdg";
		String pat = "agoodboyryobdooga";
		RabinKarpStrSearch strSearch = new RabinKarpStrSearch(pat);
		int offset = strSearch.search(str);
		if (offset == -1) {
			System.out.println("no match");
		} else {
			System.out.println("offset = " + offset + " >>> "
					+ str.substring(offset, offset + pat.length()));
		}

	}

}
