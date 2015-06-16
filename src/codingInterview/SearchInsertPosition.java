package codingInterview;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 4, 6, 8, 9 };
		int target = 18;

		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			insertPosition(array, target);
		}
		long endTime = System.nanoTime();
		System.out.println("insertPosition       >>> cost time : "
				+ (endTime - startTime));
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			binarySearchPosition(array, target);
		}
		endTime = System.nanoTime();
		System.out.println("binarySearchPosition >>> cost time : "
				+ (endTime - startTime));
	}

	/**
	 * O(log n)
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	private static int binarySearchPosition(int[] array, int target) {
		// TODO Auto-generated method stub
		if (array == null) {
			return -1;
		}
		int len = array.length;
		int start = 0;
		int end = len - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				start = mid + 1;
			} else if (array[mid] > target) {
				end = mid - 1;
			}

		}
		return end + 1;
	}

	/**
	 * O(n), a naive approach
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	private static int insertPosition(int[] array, int target) {
		// TODO Auto-generated method stub
		if (array == null) {
			return -1;
		}
		int len = array.length;
		for (int i = 0; i < len; i++) {
			if (array[i] == target) {
				return i;
			} else if (array[i] > target) {
				return i;
			}
		}
		return len;
	}

}
