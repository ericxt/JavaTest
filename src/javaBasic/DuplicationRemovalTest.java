package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DuplicationRemovalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"a", "b", "c", "a", "e", "d", "c"};
		List<String> list = new ArrayList<String>(Arrays.asList(str));
		System.out.println(list);
		HashSet<String> hashSet = new HashSet<String>(list);
		list.clear();
		list.addAll(hashSet);
		System.out.println(list);

	}

}
