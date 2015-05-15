package javaBasic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void test() {
		int[] a = new int[4];
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass().getSuperclass().getName());
//		fail("Not yet implemented");
	}

}
