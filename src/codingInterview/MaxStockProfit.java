package codingInterview;

public class MaxStockProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stock = { 3, 1, 3, 8, 9, 10 };
		// int profit = maxProfit1(stock);
		// System.out.println(profit);

		// int profit = maxProfit2(stock);
		// System.out.println(profit);

		// int profit = maxProfit3(stock);
		// System.out.println(profit);

		// int profit = maxProfit4(stock);
		// System.out.println(profit);

		int k = 3;
//		int profit = maxProfit5(k, stock);
//		System.out.println(profit);
		
		int profit = maxProfit6(k, stock);
		System.out.println(profit);

	}

	/**
	 * complete at most k transactions
	 * 1D dynamic programming
	 * @param k
	 * @param stock
	 * @return
	 */
	private static int maxProfit6(int k, int[] stock) {
		// TODO Auto-generated method stub
		if (k <= 0 || stock == null || stock.length < 2) {
			return 0;
		}
		
		int len = stock.length;
		int[] local = new int[k + 1];
		int[] global = new int[k + 1];
		
		for (int i = 0; i < len - 1; i++) {
			int diff = stock[i + 1] - stock[i];
			for (int j = k; j > 0; j--) {
				local[j] = Math.max(local[j] + diff, global[j - 1] + Math.max(0, diff));
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}

	/**
	 * complete at most k transactions
	 * 2D dynamic programming
	 * @param k
	 * @param stock
	 * @return
	 */
	private static int maxProfit5(int k, int[] stock) {
		// TODO Auto-generated method stub
		if (k <= 0 || stock == null || stock.length < 2) {
			return 0;
		}
		int len = stock.length;
		// The local array tracks maximum profit of j transactions 
		// and the last transaction is on ith day. 
		int[][] local = new int[len][k + 1];
		// The global array tracks the maximum profit of j transactions until ith day.
		int[][] global = new int[len][k + 1];

		for (int i = 1; i < len; i++) {
			int diff = stock[i] - stock[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(local[i - 1][j] + diff,
						global[i - 1][j - 1] + Math.max(diff, 0));
				global[i][j] = Math.max(local[i][j], global[i - 1][j]);
			}
		}
		return global[len - 1][k];
	}

	/**
	 * complete at most 2 transactions divide and conquer
	 * 
	 * @param stock
	 * @return
	 */
	private static int maxProfit4(int[] stock) {
		// TODO Auto-generated method stub
		if (stock == null || stock.length < 2) {
			return 0;
		}
		int profit = 0;
		int[] left = new int[stock.length];
		int[] right = new int[stock.length];
		maxProfit4(stock, 1, stock.length, left, right, profit);
		printArray(left);
		printArray(right);

		for (int i = 0; i < stock.length; i++) {
			if (profit < left[i] + right[i]) {
				profit = left[i] + right[i];
			}
		}

		return profit;
	}

	/**
	 * helper function for maxProfit4
	 * 
	 * @param stock
	 * @param start
	 * @param length
	 * @param right
	 * @param left
	 * @param profit
	 */
	private static void maxProfit4(int[] stock, int start, int length,
			int[] left, int[] right, int profit) {
		// TODO Auto-generated method stub

		for (int i = start; i < length; i++) {
			if (stock[i] > stock[i - 1]) {
				left[i] = left[i - 1] + stock[i] - stock[i - 1];
			}
			if (stock[length - i - 1] < stock[length - i]) {
				right[length - i - 1] = right[length - i] + stock[length - i]
						- stock[length - i - 1];
			}
		}

	}

	/**
	 * utility function
	 * 
	 * @param left
	 */
	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null || arr.length == 0) {
			System.out.println("null");
		}
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.println(arr[i]);
			}
		}

	}

	/**
	 * complete as many as one likes
	 * 
	 * @param stock
	 * @return
	 */
	private static int maxProfit3(int[] stock) {
		// TODO Auto-generated method stub
		if (stock == null || stock.length < 2) {
			return 0;
		}

		int profit = 0;
		for (int i = 1; i < stock.length; i++) {
			int diff = stock[i] - stock[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}

	/**
	 * complete at most one transaction
	 * 
	 * @param stock
	 * @return
	 */
	private static int maxProfit2(int[] stock) {
		// TODO Auto-generated method stub
		if (stock == null || stock.length < 2) {
			return 0;
		}

		int profit = 0;
		int minElem = Integer.MAX_VALUE;

		for (int i = 0; i < stock.length; i++) {
			profit = Math.max(profit, stock[i] - minElem);
			minElem = Math.min(minElem, stock[i]);
		}
		return profit;
	}

	/**
	 * complete at most one transaction
	 * 
	 * @param stock
	 * @return
	 */
	private static int maxProfit1(int[] stock) {
		// TODO Auto-generated method stub
		if (stock == null || stock.length < 2) {
			return 0;
		}
		int profit = Integer.MIN_VALUE;
		for (int i = 0; i < stock.length - 1; i++) {
			for (int j = 0; j < stock.length; j++) {
				if (profit < stock[j] - stock[i]) {
					profit = stock[j] - stock[i];
				}
			}
		}
		return profit;
	}

}
