package javaBasic;

public class IterationVSRecursionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testNum = 10;

		long startTime = System.nanoTime();
		int result = factWithRecursion(testNum);
		long endTime = System.nanoTime();
		System.out.println(result + " >>> " + (endTime - startTime));

		startTime = System.nanoTime();
		result = factWithIteration(testNum);
		endTime = System.nanoTime();
		System.out.println(result + " >>> " + (endTime - startTime));

	}

	private static int factWithIteration(int testNum) {
		// TODO Auto-generated method stub
		int result = 1;
		for (int i = 2; i < testNum + 1; i++) {
			result *= i;
		}
		return result;
	}

	private static int factWithRecursion(int testNum) {
		// TODO Auto-generated method stub
		if (testNum == 1) {
			return 1;
		} else {
			return testNum * factWithRecursion(testNum - 1);
		}
	}

}
