package interviewKeepsake;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, 6, 2, 9, 1, 7 };
		printArray(a);
		bubbleSort(a);
		printArray(a);

	}

	private static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			System.out.println("initialize the array");
			return;
		}
		
		for (int i = 0; i < a.length - 1; i++) {
			int cur = a[i];
			int index = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j - 1] < a[j]) {
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
			
			int tmp = a[a.length - 1];
			a[a.length - 1] = a[i];
			a[i] = tmp;
			printArray(a);
			
		}

	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			System.out.println("no elements");
		}

		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
				System.out.print(a[i] + " ");
			} else {
				System.out.println(a[i]);
			}
		}
	}

}
