package codingInterview;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, 1, 5, 5, 1 };
//		int index = findPeak1(a);
//		System.out.println(index + ", " + a[index]);
		
		int index = findPeak2(a);
		System.out.println(index + ", " + a[index]);

	}

	private static int findPeak2(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return -1;
		}
		
		int index = 0;
		int max = a[0];
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] > a[i - 1] && a[i] > a[i + 1] && a[i] > max) {
				index = i;
				max = a[i];
			}
		}
		if (a[a.length - 1] > max) {
			index = a.length - 1;
			max = a[a.length - 1];
		}
		return index;
	}

	/**
	 * peak is the element larger than its neighbors 
	 * suppose a[-1],a[n] to be Integer.minvalue
	 * 
	 * @param a
	 * @return
	 */
	private static int findPeak1(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return -1;
		}
		int length = a.length;
		int index = -1;
		int max = Integer.MIN_VALUE;
		if (length == 1)
			return 0;

		for (int i = 0; i < length; i++) {
			if (i != 0 && i != length - 1) {
				if (a[i] > a[i - 1] && a[i] > a[i + 1] && a[i] > max) {
					index = i;
					max = a[i];
				}
			} else if (i == 0) {
				if (a[i] > a[i + 1] && a[i] > max) {
					index = i;
					max = a[i];
				}
			} else if (i == length - 1) {
				if (a[i] > a[i - 1] && a[i] > max) {
					index = max;
					max = a[i];
				}
			}
		}
		return index;
	}

}
