package codingInterview;

public class DispatchCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] children = { 7, 6, 5, 2, 3, 4, 7, 6, 9 };
		int total = dispatch(children);
		System.out.println(total);

	}

	private static int dispatch(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int[] candy = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				candy[i] = 1;
			} else if (arr[i] > arr[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i] && candy[i - 1] <= candy[i]) {
				candy[i - 1] = candy[i] + 1;
			}
		}
		printArray(arr);
		printArray(candy);
		
		return sum(candy);
	}

	private static int sum(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null || arr.length == 0) {
			System.out.println("invalid array");
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null || arr.length == 0) {
			System.out.println("invalid array");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
		
	}

}
