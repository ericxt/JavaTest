package codingInterview;

public class Median {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 3, 4, 6, 7, 8, 9, 10, 13 };
		int[] b = { 1, 2, 3, 5, 6, 9, 9, 12, 15, 18, 20 };
		int[] c = { 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 12, 13, 15,
				18, 20 };
		// System.out.println(c[c.length/2 - 1] + c[c.length/2]);
		double median = naiveMedian(a, b);
		System.out.println("naiveMedian : " + median);
		median = findMedian(a, b);
		System.out.println("findMedian : " + median + ", " + count);
	}

	/**
	 * O(m+n)
	 * @param a
	 * @param b
	 * @return
	 */
	private static double naiveMedian(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int aLen = a.length;
		int bLen = b.length;
		int i = 0, j = 0, k = 0;
		int[] c = new int[aLen + bLen];
		while (i < aLen && j < bLen) {
			if (a[i] <= b[j]) {
				c[k] = a[i];
				i++;
				k++;
			} else {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		while (i < aLen) {
			c[k] = a[i];
			i++;
			k++;
		}
		while (j < bLen) {
			c[k] = b[j];
			j++;
			k++;
		}
		// for (i = 0; i < c.length; i++) {
		// System.out.print(c[i]);
		// }
		// System.out.println();

		int cLen = c.length;
		if (cLen % 2 != 0) {
			System.out.println("odd");
			return c[cLen / 2 - 1];
		} else {
			return (c[cLen / 2 - 1] + c[cLen / 2]) * 0.5;
		}
	}

	/**
	 * O(log(m+n))
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static double findMedian(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int aLen = a.length;
		int bLen = b.length;
		if ((aLen + bLen) % 2 != 0) {
			return findKth(a, b, (aLen + bLen) / 2, 0, aLen - 1, 0, bLen - 1);
		} else {
			return (findKth(a, b, (aLen + bLen) / 2, 0, aLen - 1, 0, bLen - 1) + findKth(
					a, b, (aLen + bLen) / 2 - 1, 0, aLen - 1, 0, bLen - 1)) * 0.5;
		}
	}

	private static double findKth(int[] a, int[] b, int k, int aStart,
			int aEnd, int bStart, int bEnd) {
		// TODO Auto-generated method stub
		count++;
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		if (aLen == 0) {
			return b[bStart + k];
		}
		if (bLen == 0) {
			return a[aStart + k];
		}
		if (k == 0) {
			return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
		}

		int aMid = aLen * k / (aLen + bLen);
		int bMid = k - aMid - 1;
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (a[aMid] > b[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else if (a[aMid] < b[bMid]) {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		} else {
			return a[aMid];
		}
		return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
	}

}
