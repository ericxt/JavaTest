package moreAboutJava;

import java.util.HashSet;

public class SetForUniquesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray = new String[] { "a", "b", "c", "d", "e", "f", "f",
				"d", "a", "b", "h", "o", "j" };
		HashSet<String> uniqueSet = new HashSet<String>();
		HashSet<String> dupSet = new HashSet<String>();
		
		for (String s : strArray) {
			if (!uniqueSet.add(s)) {
				dupSet.add(s);
			}
		}
		uniqueSet.removeAll(dupSet);
		
		System.out.println(uniqueSet);
		System.out.println(dupSet);

	}

}
