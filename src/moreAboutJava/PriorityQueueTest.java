package moreAboutJava;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	static class PQSort implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 1, 2, 6, 8, 3, 5, 0, 10, 4, 6, 7, 2 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		for (int i : intArray) {
			pq1.offer(i);
		}
		System.out.println(pq1);

		PQSort pqSort = new PQSort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(intArray.length, pqSort);
		for (int i : intArray) {
			pq2.offer(i);
		}
		System.out.println(pq2);
		
		System.out.println("peek : " + pq2.peek() + " >>> " + pq2.size());
		System.out.println("poll : " + pq2.poll() + " >>> " + pq2.size());
		System.out.println(pq1.comparator());

	}

}
