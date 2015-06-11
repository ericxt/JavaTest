package codingInterview;

import java.io.IOException;

/**
 * for n = 7, k = 3, change [1,2,3,4,5,6,7] to [5,6,7,1,2,3,4]
 * 
 * @author txie
 *
 */
public class RotateArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7 };
		int length = intArray.length;
		int k = 3;
		int toK = kTransform(k, length);

		/**
		while (k < 8) {
			int toK = kTransform(k, length);
			System.out.print(k + " >>> " + toK + " : ");
			rotateArray1(intArray, toK);
			k++;
		}
		**/
		
//		rotateArray2(intArray, k);
		
//		rotateArray3(intArray, toK);
		
//		rotateArray4(intArray, k);

		// efficiency test
		// for rotateArray1
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			rotateArray1(intArray, 7);
		}
		long endTime = System.nanoTime();
		System.out
				.println(" rotateArray1 cost time : " + (endTime - startTime));

		// for rotateArray2
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			rotateArray2(intArray, 7);
		}
		endTime = System.nanoTime();
		System.out
				.println(" rotateArray2 cost time : " + (endTime - startTime));
		
		// for rotateArray3
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			rotateArray3(intArray, 7);
		}
		endTime = System.nanoTime();
		System.out
		.println(" rotateArray3 cost time : " + (endTime - startTime));
		
		// for rotateArray4
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			rotateArray4(intArray, 7);
		}
		endTime = System.nanoTime();
		System.out
		.println(" rotateArray4 cost time : " + (endTime - startTime));
		

	}


	private static int kTransform(int k, int length) {
		// TODO Auto-generated method stub
		if (k > length) {
			k = k % length;
		} else if (k < 0) {
			int n = k / (-length);
			k = k + (n + 1) * length;
		}
		return k;
	}
	
	/**
	 * divide into 2 part, then reverse each part
	 * like n = 6, k = 2, [1,2,3,4,5,6] --> [1,2,3,4] and [5,6] --> [4,3,2,1] and [6,5]
	 * --> [4,3,2,1,6,5] --> [5,6,1,2,3,4]
	 * @param intArray
	 * @param k
	 */
	private static void rotateArray4(int[] intArray, int k) {
		// TODO Auto-generated method stub
		int length = intArray.length;
		reverse(intArray, 0, length - k - 1);
		reverse(intArray, length - k, length - 1);
		reverse(intArray, 0, length - 1);
		
//		for (int i : intArray) {
//			System.out.print(i);
//		}
	}
	
	private static void reverse(int[] intArray, int left, int right) {
		int temp;
		while (left < right) {
			temp = intArray[right];
			intArray[right] = intArray[left];
			intArray[left] = temp;
			left ++;
			right --;
		}
	}
	
	
	/**
	 *  bubble rotate : like the bubble sort
	 *  O(1) space, but O(k*n) time
	 * @param intArray
	 * @param k
	 */
	private static void rotateArray3(int[] intArray, int k) {
		if (intArray == null)
			throw new IllegalArgumentException("intArray is null");
		int length = intArray.length;
		int temp;
		
		for (int i = 0; i < k; i++) {
			for(int j = length -1; j > 0; j--) {
				temp = intArray[j];
				intArray[j] = intArray[j -1];
				intArray[j - 1] = temp;
			}
		}
		
//		for (int i : intArray) {
//			System.out.print(i);
//		}
	}

	private static void rotateArray2(int[] intArray, int k) {
		// TODO Auto-generated method stub
		int length = intArray.length;
		int[] result = new int[length];

		System.arraycopy(intArray, 0, result, k, length - k);
		System.arraycopy(intArray, length - k, result, 0, k);

//		for (int i : result) {
//			System.out.print(i);
//		}
//		System.out.println();

	}

	private static void rotateArray1(int[] intArray, int k) {
		// TODO Auto-generated method stub
		int length = intArray.length;
		int[] result = new int[length];

		for (int i = 0; i < length - k; i++) {
			result[i + k] = intArray[i];
		}
		for (int i = 0; i < k; i++) {
			result[i] = intArray[length - k + i];
		}

		// System.arraycopy(result, 0, intArray, 0, length);

//		for (int i : result) {
//			System.out.print(i);
//		}
//		System.out.println();

	}

}
