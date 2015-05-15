package javaBasic;

import java.util.HashMap;

class Apple {
	private String color;

	public Apple(String color) {
		this.color = color;
	}

	public int hashCode() {
		return this.color.length();
	}
	
	public boolean equals(Object o) {
//		if (!(o instanceof Apple))
//			return false;
//		if (o == this)
//			return true;
		return this.color.equals(((Apple) o).color);
	}
}

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Apple, Integer> map = new HashMap<Apple, Integer>();
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");

		map.put(a1, 10);
		map.put(a2, 20);

		System.out.println(map.get(new Apple("green")));

	}

}
