package javaBasic;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

class Foo implements Comparable<Foo> {
	private int size;
	
	public Foo(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Foo o) {
		// TODO Auto-generated method stub
		return size - o.size;
	}
}

public class SetPerformanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Foo> hashSet = new HashSet<Foo>();
		TreeSet<Foo> treeSet = new TreeSet<Foo>();
		LinkedHashSet<Foo> linkedHashSet = new LinkedHashSet<Foo>();
		
		testHashSetAdd(hashSet);
		testTreeSetAdd(treeSet);
		testLinkedHashSet(linkedHashSet);

	}

	private static void testLinkedHashSet(LinkedHashSet<Foo> linkedHashSet) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			x = random.nextInt(1000-10) + 10;
			linkedHashSet.add(new Foo(x));
		}
		long endTime = System.nanoTime();
		System.out.println("linkedHashSet add : " + (endTime - startTime));
		
	}

	private static void testTreeSetAdd(TreeSet<Foo> treeSet) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			x = random.nextInt(1000-10) + 10;
			treeSet.add(new Foo(x));
		}
		long endTime = System.nanoTime();
		System.out.println("treeSet add       : " + (endTime - startTime));
		
	}

	private static void testHashSetAdd(HashSet<Foo> hashSet) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x;
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			x = random.nextInt(1000-10) + 10;
			hashSet.add(new Foo(x));
		}
		long endTime = System.nanoTime();
		System.out.println("hashSet add       : " + (endTime - startTime));
		
	}

}
