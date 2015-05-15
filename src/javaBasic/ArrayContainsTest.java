package javaBasic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayContainsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// size of str : 5
//		String[] str = new String[] { "CD", "BC", "EF", "DE", "AB" };
//		boolean flag = false;
		
		// size of str : 1k and 10k
		String[] str = new String[1000];
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			str[i] = String.valueOf(random.nextInt());
		}
		long s_time = System.nanoTime();
		Arrays.sort(str);
		long e_time = System.nanoTime();
		System.out.println("sorted time : " + (e_time - s_time)/1000000);
/**
		// useList
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useList(str, "AB");
		}
		long endTime = System.nanoTime();
		System.out.println("useList : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);

		// useSet
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useSet(str, "AB");
		}
		endTime = System.nanoTime();
		System.out.println("useSet : " + flag + " >>> " + (endTime - startTime)
				/ 1000000);

		// useLoop
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useLoop(str, "AB");
		}
		endTime = System.nanoTime();
		System.out.println("useLoop : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);

		// useBinarySearch
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useBinarySearch(str, "AB");
		}
		endTime = System.nanoTime();
		System.out.println("useBinarySearch : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);
**/

		// test for str[5]
//		useListTest(str, "AB");
//		useSetTest(str, "AB");
//		useLoopTest(str, "AB");
//		useBinarySearchTest(str, "AB");
		
		// test for str[1k]
		useListTest(str, "1");
		useSetTest(str, "1");
		useLoopTest(str, "1");
		useBinarySearchTest(str, "1");
	}

	// array contains methods

	private static boolean useList(String[] str, String targetStr) {
		return Arrays.asList(str).contains(targetStr);
	}

	private static boolean useSet(String[] str, String targetStr) {
		HashSet<String> set = new HashSet<String>(Arrays.asList(str));
		return set.contains(targetStr);
	}

	private static boolean useLoop(String[] str, String targetStr) {
		for (String s : str) {
			if (s.equals(targetStr)) {
				return true;
			}
		}
		return false;
	}

	private static boolean useBinarySearch(String[] str, String targetStr) {
		int search = Arrays.binarySearch(str, targetStr);
		if (search > 0) {
			return true;
		}
		return false;
	}

	// time test methods
	private static void useListTest(String[] str, String targetStr) {
		boolean flag = false;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useList(str, targetStr);
		}
		long endTime = System.nanoTime();
		System.out.println("useList : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);
	}
	
	private static void useSetTest(String[] str, String targetStr) {
		boolean flag = false;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useSet(str, targetStr);
		}
		long endTime = System.nanoTime();
		System.out.println("useSet : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);
	}
	
	private static void useLoopTest(String[] str, String targetStr) {
		boolean flag = false;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useLoop(str, targetStr);
		}
		long endTime = System.nanoTime();
		System.out.println("useLoop : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);
	}
	
	private static void useBinarySearchTest(String[] str, String targetStr) {
		boolean flag = false;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			flag = useBinarySearch(str, targetStr);
		}
		long endTime = System.nanoTime();
		System.out.println("useBinarySearch : " + flag + " >>> "
				+ (endTime - startTime) / 1000000);
	}

}
