package javaBasic;

import java.util.Iterator;
import java.util.TreeSet;

class Cat implements Comparable<Cat> {
	private int size;
	
	public Cat(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
	
	@Override
	public int compareTo(Cat o) {
		// TODO Auto-generated method stub
		return size - o.getSize();
	}
	
	
}

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * add some integers, and print out
		 */
		/**
		TreeSet<Integer> intSet = new TreeSet<Integer>();
		intSet.add(1);
		intSet.add(10);
		intSet.add(43);
		Iterator<Integer> itr = intSet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		**/
		
		TreeSet<Cat> set = new TreeSet<Cat>();
		set.add(new Cat(10));
		set.add(new Cat(30));
		set.add(new Cat(40));
		set.add(new Cat(3));
		Iterator<Cat> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getSize() + " ");
		}

	}

}
