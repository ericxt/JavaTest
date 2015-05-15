package javaBasic;

import java.util.HashMap;
import java.util.TreeMap;

class Dog {
	private String color;

	Dog(String color) {
		this.color = color;
	}

	// override equals(), hashCode()
	public boolean equals(Object o) {
		return ((Dog) o).color.equals(this.color);
	}

	public int hashCode() {
		return color.length();
	}

	public String toString() {
		return color + " dog";
	}
}

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Dog, Integer> map = new HashMap<Dog, Integer>();

		Dog d1 = new Dog("red");
		Dog d2 = new Dog("green");
		Dog d3 = new Dog("yellow");
		// the key same with d1
		Dog d4 = new Dog("red");

//		map.put(d1, 1);
		map.put(d2, 2);
		map.put(d3, 3);
		// d1 overlapped
		map.put(d4, 3);
		System.out.println(map.size());
		System.out.println(map);

	}

}
