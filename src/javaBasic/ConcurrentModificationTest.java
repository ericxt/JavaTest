package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("ef");
		list.add("ab");
		list.add("ce");
		System.out.println(list);
		
		// throw concurrentmodificationexception theoretically
		for (String str : list) {
			if (str.equals("ab")) {
				list.remove(str);
			}
		}
		System.out.println(list);

		// solution1 : use iterator()
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (key.equals("ef")) {
				iterator.remove();
			}
		}
		System.out.println(list);

		// solution2 : use copyonwritearraylist
		List<String> safeList = new CopyOnWriteArrayList<String>();
		safeList.add("a");
		safeList.add("b");
		safeList.add("e");
		for (String str : safeList) {
			if (str.equals("b")) {
				safeList.remove(str);
			}
		}
		System.out.println(safeList);

	}

}
