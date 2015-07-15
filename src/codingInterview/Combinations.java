package codingInterview;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, k = 3;
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();

		// combinations = recursion(n, k);
		combinations = dfs(n, k);
		printList(combinations);

	}

	/**
	 * depth-first algorithm
	 * @param n
	 * @param k
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> dfs(int n, int k) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (n <= 0 || n < k) {
			return result;
		}
		dfs(n, k, 1, item, result);
		return result;
	}

	private static void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> result) {
		// TODO Auto-generated method stub
		if (item.size() == k) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
		
		for (int i = start; i < n + 1; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, result);
			item.remove(item.size() - 1);
		}
		
	}

	/**
	 * recursion algorithm
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> recursion(int n, int k) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (k > n) {
			return result;
		} else if (k == n) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int i = 1; i < n + 1; i++) {
				tmp.add(i);
			}
			result.add(tmp);
			return result;
		} else if (k == 1) {
			for (int i = 1; i < n + 1; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				result.add(tmp);
			}
			return result;
		} else {
			for (int i = 1; i <= n - k + 1; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				result.add(tmp);
			}
			recursion(n, k, result);

			return result;
		}
	}

	private static void recursion(int n, int k,
			ArrayList<ArrayList<Integer>> result) {
		// TODO Auto-generated method stub
		if (result.get(0).size() == k) {
			return;
		}

		ArrayList<ArrayList<Integer>> preResult = new ArrayList<ArrayList<Integer>>();
		preResult.addAll(result);
		result.clear();

		for (ArrayList<Integer> elem : preResult) {
			for (int i = 1; i < n + 1; i++) {
				if (i > elem.get(elem.size() - 1)) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(elem);
					tmp.add(i);
					result.add(tmp);
				}
			}
		}
		recursion(n, k, result);

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

}
