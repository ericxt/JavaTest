package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
		int[] nums = { 2, 7, 4, 11, 4, 8, 13, 1, 7, 0};
		int target = 8;
		// ArrayList<Indice> result = myTwoSumForSorted(nums, target);
//		ArrayList<Indice> result = myTwoSum(nums, target);
//		ArrayList<Indice> result = mapTwoSum(nums, target);
		ArrayList<Indice> result = TwoSumForSorted(nums, target);
		for (Indice indice : result) {
			System.out.print("[" + indice.index1 + ", " + indice.index2 + "] ");
		}
		System.out.println();
	}

	private static ArrayList<Indice> TwoSumForSorted(int[] nums, int target) {
		// TODO Auto-generated method stub
		ArrayList<Indice> result = new ArrayList<Indice>();
		int i = 0;
		int j = nums.length - 1;
		Arrays.sort(nums);
		while (i < j) {
			int tmp = nums[i] + nums[j];
			if (tmp < target) {
				i++;
			} else if (tmp > target) {
				j--;
			} else {
				Indice indice = new Indice(i + 1, j + 1);
				result.add(indice);
				i++;
				j--;
			}
		}
		return result;
	}

	/**
	 * use hashmap, O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ArrayList<Indice> mapTwoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Indice> result = new ArrayList<Indice>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				Indice indice = new Indice(i + 1, map.get(nums[i]) + 1);
				result.add(indice);
			} else {
				map.put(target - nums[i], i);
			}
		}
		return result;
	}

	/**
	 * naive solution
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ArrayList<Indice> myTwoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		ArrayList<Indice> result = new ArrayList<Indice>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (visited.contains(i)) {
				continue;
			}
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					Indice indice = new Indice(Math.min(i + 1, j + 1),
							Math.max(i + 1, j + 1));
					result.add(indice);
					visited.add(j);
				}
			}
		}
		return result;
	}

	/**
	 * for sorted array, so limited
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ArrayList<Indice> myTwoSumForSorted(int[] nums, int target) {
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
