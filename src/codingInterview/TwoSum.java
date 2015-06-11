package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;

class Indice {
	int index1;
	int index2;

	Indice() {
	}

	Indice(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
}

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 11, 13, 1, 8};
		int target = 9;
		ArrayList<Indice> result = myTwoSum(nums, target);
		for (Indice indice : result) {
			System.out.print("[" + indice.index1 + ", " + indice.index2 + "] ");
		}
		System.out.println();
	}

	private static ArrayList<Indice> myTwoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		ArrayList<Indice> result = new ArrayList<Indice>();
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					Indice indice = new Indice(Math.min(i + 1, j + 1),
							Math.max(i + 1, j + 1));
					result.add(indice);
				}
				if (nums[i] + nums[j] > target) {
					continue;
				}
			}
		}
		return result;
	}
}
