package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int target = 8;
		ArrayList<ArrayList<Integer>> result = combinationSum(a, target);
//		System.out.println(result);
		
		printList(result);

	}

	private static void printList(ArrayList<ArrayList<Integer>> result) {
		// TODO Auto-generated method stub
		if (result == null || result.size() == 0) {
			System.out.println(result);
		}
		for (ArrayList<Integer> elem : result) {
			System.out.println(elem);
		}
		
	}

	private static ArrayList<ArrayList<Integer>> combinationSum(int[] a,
			int target) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return null;
		}

		Arrays.sort(a);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> combination = new ArrayList<Integer>();
		combinationSum(a, target, 0, combination, result);
		return result;
	}

	private static void combinationSum(int[] a, int target, int start,
			ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> result) {
		// TODO Auto-generated method stub
		if (target == 0) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(combination);
			result.add(tmp);
			return;
		}

		for (int i = start; i < a.length; i++) {
			if (a[i] > target) {
				return;
			}

			combination.add(a[i]);
			// pay attention to i, not change
			combinationSum(a, target - a[i], i, combination, result);
			combination.remove(combination.size() - 1);
		}

	}
}
