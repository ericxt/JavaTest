package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;

class Triplet {
	int x;
	int y;
	int z;

	Triplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, -1, 2, -2, 5, -2, -3, -5, 7 };
		// ArrayList<Triplet> result = MyThreeSum(nums);
		ArrayList<Triplet> result = BetterThreeSum(nums);
		for (Triplet res : result) {
			System.out.println("[ " + res.x + ", " + res.y + ", " + res.z
					+ " ]");
		}
	}

	/**
	 * use two pointers respecting to start and end O(n^2) can handle duplicates
	 * 
	 * @param nums
	 * @return
	 */
	private static ArrayList<Triplet> BetterThreeSum(int[] nums) {
		// TODO Auto-generated method stub
		ArrayList<Triplet> result = new ArrayList<Triplet>();
		Arrays.sort(nums);
		int len = nums.length;
		if (nums == null || len < 3) {
			return result;
		}
		for (int i = 0; i < len - 2; i++) {
			// avoid generating duplicates
			if (i == 0 || nums[i] > nums[i - 1]) {
				int start = i + 1;
				int end = len - 1;
				int negate = -nums[i];
				while (start < end) {
					if (nums[start] + nums[end] > negate) {
						end--;
					} else if (nums[start] + nums[end] < negate) {
						start++;
					} else {
						Triplet triplet = new Triplet(nums[i], nums[start],
								nums[end]);
						result.add(triplet);
						start++;
						end--;

						// avoid generating duplicates
						while (start < end && nums[end] == nums[end + 1]) {
							end--;
						}

						while (start < end && nums[start] == nums[start - 1]) {
							start++;
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * look for a triplet to satisfy that the sum is zero. O(n^3) does not
	 * handle duplicates
	 * 
	 * @param nums
	 * @return
	 */
	private static ArrayList<Triplet> MyThreeSum(int[] nums) {
		// TODO Auto-generated method stub
		ArrayList<Triplet> result = new ArrayList<Triplet>();
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0)
				break;
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] > 0 && nums[j] > 0)
					break;
				for (int k = j + 1; k < len; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						Triplet triplet = new Triplet(nums[i], nums[j], nums[k]);
						result.add(triplet);
						break;
					}
				}
			}
		}
		return result;
	}

}
