package codingInterview;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int closestSum = ThreeSumClosest(nums, target);
		System.out.println(closestSum);
	}

	/**
	 * approach similar with ThreeSum, O(n^2)
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int ThreeSumClosest(int[] nums, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int len = nums.length;
		if (nums == null || len < 3)
			return Integer.MAX_VALUE;
		int minGap = Integer.MAX_VALUE;
		int closestSum = Integer.MAX_VALUE;
		for (int i = 0; i < len - 2; i++) {
			int start = i +1;
			int end = len - 1;
			int negate = -nums[i];
			
			while (start < end) {
				if (nums[start] + nums[end] > negate) {
					if (Math.abs(nums[i] + nums[start] + nums[end] - target) < minGap) {
						minGap = Math.abs(nums[i] + nums[start] + nums[end] - target);
						closestSum = nums[i] + nums[start] + nums[end];
					}
					end--;
				} else if (nums[start] + nums[end] < negate) {
					if (Math.abs(nums[i] + nums[start] + nums[end] - target) < minGap) {
						minGap = Math.abs(nums[i] + nums[start] + nums[end] - target);
						closestSum = nums[i] + nums[start] + nums[end];
					}
					start++;
				} else {
					return target;
				}
			}
		}
		return closestSum;
	}

}
