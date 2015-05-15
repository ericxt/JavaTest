package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class FilterCollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : intArray) {
			list.add(i);
		}

		filter(list, new Predicate<Integer>() {

			@Override
			public boolean test(Integer i) {
				// TODO Auto-generated method stub
				return i <= 4;
			}
		});
		
		System.out.println(list);

	}

	private static void filter(ArrayList<Integer> list,
			Predicate<Integer> predicate) {
		// TODO Auto-generated method stub
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (!predicate.test(next)) {
				iterator.remove();
			}
		}

	}

}
