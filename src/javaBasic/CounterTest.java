package javaBasic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MutableInteger {
	private int val;

	public MutableInteger(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String toString() {
		return Integer.toString(val);
	}

}

public class CounterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "England", "Greek", "France", "China", "Japan",
				"England", "France", "Japan", "China", "England", "England",
				"China", "China", "Greek", "China", "Germany", "Russia",
				"China", "Italy" };

		long startTime;
		long endTime;

		/**
		 * jdk 8
		 */
		/**
		 * startTime = System.nanoTime(); for (int i = 0; i < 1000000; i++) {
		 * Stream<String> stream = Stream.of(str).parallel(); Map<String, Long>
		 * map = stream.collect(Collectors.groupingBy( String::toString,
		 * Collectors.counting())); } endTime = System.nanoTime();
		 * System.out.println("jdk 8 Time             : " + (endTime -
		 * startTime));
		 **/

		/**
		 * naive counter
		 */
		// integer : immutable, when increment, create a new Integer
		startTime = System.nanoTime();
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				if (hashMap.containsKey(s)) {
					Integer oldValue = hashMap.get(s);
					hashMap.put(s, oldValue + 1);
				} else {
					hashMap.put(s, 1);
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("naive counter Time     : " + (endTime - startTime));

		/**
		 * better counter
		 */
		// more efficient theoretically
		// make integer mutable
		startTime = System.nanoTime();
		HashMap<String, MutableInteger> mutableMap = new HashMap<String, MutableInteger>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				if (mutableMap.containsKey(s)) {
					MutableInteger oldValue = mutableMap.get(s);
					oldValue.setVal(oldValue.getVal() + 1);
				} else {
					mutableMap.put(s, new MutableInteger(1));
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("better counter Time    : " + (endTime - startTime));

		/**
		 * efficient counter
		 */
		startTime = System.nanoTime();
		HashMap<String, MutableInteger> efficientCounter = new HashMap<String, MutableInteger>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				MutableInteger initValue = new MutableInteger(1);
				// put() returns the current value of key s
				MutableInteger oldValue = efficientCounter.put(s, initValue);

				if (oldValue != null) {
					oldValue.setVal(oldValue.getVal() + 1);
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("efficient counter Time : " + (endTime - startTime));

		/**
		 * better approach without containsKey
		 */
		startTime = System.nanoTime();
		HashMap<String, MutableInteger> betterCounter = new HashMap<String, MutableInteger>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				MutableInteger oldValue = betterCounter.get(s);
				if (oldValue != null) {
					oldValue.setVal(oldValue.getVal() + 1);
				} else {
					betterCounter.put(s, new MutableInteger(1));
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("better counter2 Time   : " + (endTime - startTime));

		/**
		 * better approach without containsKey, using atomicIngeter
		 */
		startTime = System.nanoTime();
		HashMap<String, AtomicInteger> atomicCounter = new HashMap<String, AtomicInteger>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				AtomicInteger oldValue = atomicCounter.get(s);
				if (oldValue != null) {
					oldValue.incrementAndGet();
				} else {
					atomicCounter.put(s, new AtomicInteger(1));
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("better counter3 Time   : " + (endTime - startTime));

		/**
		 * better approach without containsKey, using int[]
		 */
		startTime = System.nanoTime();
		HashMap<String, int[]> intCounter = new HashMap<String, int[]>();
		for (int i = 0; i < 1000000; i++) {
			for (String s : str) {
				int[] oldValue = intCounter.get(s);
				if (oldValue != null) {
					oldValue[0]++;
				} else {
					intCounter.put(s, new int[] { 1 });
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("better counter4 Time   : " + (endTime - startTime));

	}

}
