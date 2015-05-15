package javaBasic;

import java.util.ArrayList;
import java.util.Collection;

public class GenericTypeErasureTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		list.add("abc");
		list.add("def");
		
		intList.add(1);
		intList.add(2);
		
		System.out.println(">>>>>>with super");
		acceptWithSuper(list);
		// not applicable
//		acceptWithSuper(intList);
		
		System.out.println(">>>>>>with extends");
		acceptWithExtends(list);
		acceptWithExtends(intList);
		
		System.out.println(">>>>>>with ?");
		acceptWithWildcard(list);
		acceptWithWildcard(intList);
		
		// not applicable
		System.out.println(">>>>>>with Object");
//		acceptWithObject(list);
//		acceptWithObject(intList);
		
		System.out.println(">>>>>>parameter same, type different");
		acceptWithTypes(list);
		// not applicable with different parameter type
//		acceptWithTypes(intList);
		
	}

	private static void acceptWithTypes(Collection<String> list) {
		// TODO Auto-generated method stub
		for (Object o : list) {
			System.out.println(o);
		}
		
	}

	private static void acceptWithObject(ArrayList<Object> list) {
		// TODO Auto-generated method stub
		for (Object o : list) {
			System.out.println(o);
		}
		
	}

	private static void acceptWithExtends(ArrayList<? extends Object> list) {
		// TODO Auto-generated method stub
		for (Object o : list) {
			System.out.println(o);
		}
		
	}

	private static void acceptWithSuper(ArrayList<? super String> list) {
		// TODO Auto-generated method stub
		for (Object o : list) {
			System.out.println(o);
		}
		
	}

	// list can contain Object and its subtype
	private static void acceptWithWildcard(ArrayList<?> list) {
		// TODO Auto-generated method stub
		for (Object o : list) {
			System.out.println(o);
		}
		
	}

}
