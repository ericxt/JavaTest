package codingInterview;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 1, 3, 2, 4, 5 };
		int start = canComplete(gas, cost);
		System.out.println(start);

	}

	private static int canComplete(int[] gas, int[] cost) {
		// TODO Auto-generated method stub
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0
				|| gas.length != cost.length || sum(gas) < sum(cost)) {
			System.out.println("invalid array");
			return -1;
		}
		int total = 0;
		int sumRemaining = 0;
		int start = 0;
		boolean isCircular = false;

		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
			if (sumRemaining >= 0) {
				sumRemaining += remaining;
			} else {
				sumRemaining = remaining;
				start = i;
			}
			if ((start == 0 && i == 4 && sumRemaining >= 0)
					|| (start != 0 && start == i && isCircular)) {
				break;
			}
			if (start != 0 && i == 4) {
				i = 0;
				isCircular = true;
			}
			total += remaining;
		}
		if (start >= 0) {
			return start;
		} else {
			return -1;
		}
	}

	private static int sum(int[] array) {
		// TODO Auto-generated method stub
		if (array == null || array.length == 0) {
			System.out.println("invalid array");
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

}
