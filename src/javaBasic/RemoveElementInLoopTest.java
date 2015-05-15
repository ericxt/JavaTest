package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveElementInLoopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// the size and the index of arraylist changed, when list.remove()
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b",
				"c", "d"));
		for (int i = 0; i < list.size(); i++) {
			list.remove(i); 
		}
		System.out.println(list);
		
		// use foreach in a loop
		// concurrentmodificationexception
		/**
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		for (String s : list2) {
			if (s.equals("a")) {
				list2.remove(s);
			}
		}
		System.out.println(list2);
		**/
		
		// use iterator
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		Iterator<String> itr = list2.iterator();
		while (itr.hasNext()) {
			String next = itr.next();
			if (next.equals("a")) {
				itr.remove();
			}
		}
		System.out.println(list2);
		
	}
}
