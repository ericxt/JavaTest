package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays2ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "a", "b", "c", "d" };
		
		/**
		 * use Arrays.asList()
		 */
		// wrong way, create a fixed-size arraylist, and this arraylist is a
		// private static class inside Arrays
		// has no methods to add elements
		List<String> list = Arrays.asList(str);
		// can not use add()
//		list.add("f");
		System.out.println(list.getClass());
		System.out.println(list);

		/**
		 * use new ArrayList(Arrays.asList())
		 */
		// right way
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(str));
		arrayList.add("f");
		System.out.println(arrayList.getClass());
		System.out.println(arrayList);
		
		/**
		 * use foreach
		 */
		int[] intArray = {1, 2, 3, 4};
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i : intArray) {
			intList.add(i);
		}
		System.out.println(intList);
		
		/**
		 * use new ArrayList(size), and Collections.addAll()
		 */
		ArrayList<String> arrayList2 = new ArrayList<String>(str.length);
		Collections.addAll(arrayList2, str);
		System.out.println(arrayList2);

	}

}
