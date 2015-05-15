package javaBasic;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEfficiencyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		/**
		 * add() test
		 */
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		System.out.println("arrayList add     : " + (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("linkedList add    : " + (endTime - startTime));

		/**
		 * get() test
		 */
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("arrayList get     : " + (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("linkedList get    : " + (endTime - startTime));

		/**
		 * remove() test
		 */
		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		System.out.println("arrayList remove  : " + (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		System.out.println("linkedList remove : " + (endTime - startTime));

	}

}
