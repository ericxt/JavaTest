package javaBasic;

import java.util.TreeMap;

class Dogs implements Comparable<Dogs> {
	String color;
	int size;

	Dogs(String color, int size) {
		this.color = color;
		this.size = size;
	}

	public String toString() {
		return color + " dogs";
	}

	@Override
	public int compareTo(Dogs o) {
		// TODO Auto-generated method stub
		return o.size - this.size;
	}

}

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Dogs, Integer> map = new TreeMap<Dogs, Integer>();
		Dogs d1 = new Dogs("red", 10);
		Dogs d2 = new Dogs("white", 12);
		Dogs d3 = new Dogs("yellow", 20);
		Dogs d4 = new Dogs("red", 15);
		
		map.put(d1, 1);
		map.put(d2, 20);
		map.put(d3, 30);
		map.put(d4, 40);
		
		System.out.println(map);

	}

}
