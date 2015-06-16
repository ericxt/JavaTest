package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;

class Quadruplet {
	int a;
	int b;
	int c;
	int d;

	Quadruplet(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, -1, 2, -2, 5, -2, -3, -5, 7 };
		int target = 0;
//		 ArrayList<Quadruplet> result = NaiveFourSum(nums, target);
		ArrayList<Quadruplet> result = BetterFourSum(nums, target);
		System.out.println(result.size());
		for (Quadruplet res : result) {
			System.out.println("[ " + res.a + ", " + res.b + ", " + res.c
					+ ", " + res.d + " ]");
		}
		System.out.println();
	}

	/**
	 * use two pointers : start and end, O(n^3)
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ArrayList<Quadruplet> BetterFourSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		ArrayList<Quadruplet> result = new ArrayList<Quadruplet>();
		Arrays.sort(nums);
		int len = nums.length;
		if (nums == null || len < 4) {
			return result;
		}

		for (int i = 0; i < len - 3; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				for (int j = i + 1; j < len - 2; j++) {
					if (j == 1 || nums[j] > nums[j - 1]) {
						int start = j + 1;
						int end = len - 1;
						int negate = -(nums[i] + nums[j]);
						while (start < end) {
							if (nums[start] + nums[end] > negate) {
								end--;
							} else if (nums[start] + nums[end] < negate) {
								start++;
							} else {
								Quadruplet quad = new Quadruplet(nums[i],
										nums[j], nums[start], nums[end]);
								result.add(quad);
								start++;
								end--;

								while (start < end
										&& nums[start] == nums[start - 1]) {
									start++;
								}
								while (start < end
										&& nums[end] == nums[end + 1]) {
									end--;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * can not handle duplicates, O(n^4)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ArrayList<Quadruplet> NaiveFourSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		ArrayList<Quadruplet> result = new ArrayList<Quadruplet>();
		Arrays.sort(nums);
		int len = nums.length;
		if (nums == null || len < 4) {
			return result;
		}

		for (int i = 0; i < len - 3; i++) {
			if (nums[i] > target)
				break;
			for (int j = i + 1; j < len - 2; j++) {
				if (nums[i] + nums[j] > target && nums[j] > 0)
					break;
				for (int k = j + 1; k < len - 1; k++) {
					if (nums[i] + nums[j] + nums[k] > target && nums[k] > 0)
						break;
					for (int l = k + 1; l < len; l++) {
						if (nums[i] + nums[j] + nums[k] + nums[l] > target
								&& nums[l] > 0)
							break;
						if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
							Quadruplet quad = new Quadruplet(nums[i], nums[j],
									nums[k], nums[l]);
							result.add(quad);
						}
					}
				}
			}
		}
		return result;
	}

}
