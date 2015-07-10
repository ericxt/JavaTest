package codingInterview;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, k =2;
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		combinations = getCombinations(n, k);
		printList(combinations);

	}

	private static void printList(ArrayList<ArrayList<Integer>> combinations) {
		// TODO Auto-generated method stub
		if (combinations == null || combinations.size() < 1) {
			System.out.println("no element");
			return;
		}
		
		for (int i = 0; i < combinations.size(); i++) {
			System.out.println(combinations.get(i));
		}
		
	}

	private static ArrayList<ArrayList<Integer>> getCombinations(int n, int k) {
		// TODO Auto-generated method stub
		if (n == 0 || k == 0) {
			return null;
		}
		return null;
	}

}
