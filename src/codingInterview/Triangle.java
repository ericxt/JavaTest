package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(8, 5)));
		triangle.add(new ArrayList<>(Arrays.asList(3, 7, 1)));
		triangle.add(new ArrayList<>(Arrays.asList(5, 9, 2, 6)));
		System.out.println(triangle);

		int minSum = minSum(triangle);
		System.out.println(minSum);

	}

	// bottom up
	private static int minSum(ArrayList<ArrayList<Integer>> triangle) {
		// TODO Auto-generated method stub
		int size = triangle.size();
		int[] total = new int[size];
		int l = size - 1;
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}

		for (int i = l - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				total[j] = triangle.get(i).get(j)
						+ Math.min(total[j], total[j + 1]);
			}
		}
		return total[0];
	}

}
