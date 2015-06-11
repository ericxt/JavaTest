package javaBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HDTV implements Comparable<HDTV> {
	private int size;
	private String brand;

	public HDTV(int size, String brand) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int compareTo(HDTV o) {
		// TODO Auto-generated method stub
		if (this.size > o.size)
			return 1;
		else if (this.size < o.size)
			return -1;
		else
			return 0;
	}

}

class Computer implements Comparable<Computer> {
	private int size;
	private String brand;

	public Computer(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int compareTo(Computer o) {
		// TODO Auto-generated method stub
		if (this.size > o.size)
			return 1;
		else if (this.size < o.size)
			return -1;
		else
			return 0;
	}

}

class ComputerComparator implements Comparator<Computer> {

	@Override
	public int compare(Computer c1, Computer c2) {
		// TODO Auto-generated method stub
		int c1Size = c1.getSize();
		int c2Size = c2.getSize();
		if (c1Size > c2Size)
			return 1;
		else if (c1Size < c2Size)
			return -1;
		else
			return 0;
	}

}

public class ComparableAndComparaorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HDTV tv1 = new HDTV(30, "Sony");
		HDTV tv2 = new HDTV(45, "Pansanic");

		if (tv1.compareTo(tv2) == 1) {
			System.out.println(tv1.getBrand() + " is better.");
		} else if (tv1.compareTo(tv2) == -1) {
			System.out.println(tv2.getBrand() + " is better.");
		}

		System.out.println("for comoputer");

		Computer c1 = new Computer(16, "hp");
		Computer c2 = new Computer(13, "mac");
		Computer c3 = new Computer(14, "lenovo");

		ArrayList<Computer> list = new ArrayList<Computer>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		for (Computer c : list) {
			System.out.println(c.getSize() + ":" + c.getBrand());
		}

		// list.sort(new ComputerComparator());
		Collections.sort(list, new ComputerComparator());
		System.out.println("after sorting");
		for (Computer c : list) {
			System.out.println(c.getSize() + ":" + c.getBrand());
		}

		System.out.println(">>>reverse sort");
		Comparator<Computer> reverseOrder = Collections.reverseOrder();
		list.sort(reverseOrder);
		// Collections.sort(list, reverseOrder);
		for (Computer c : list) {
			System.out.println(c.getSize() + ":" + c.getBrand());
		}

	}

}
