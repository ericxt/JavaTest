package javaBasic;

import java.lang.reflect.Field;

public class StringChangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String change
		String str = "ab";
		changeString(str);
		System.out.println(str);

		// StringBuilder change
		StringBuilder builder = new StringBuilder("ab");
		changeBuilder(builder);
		System.out.println(builder);

	}

	private static void changeBuilder(StringBuilder builder) {
		// TODO Auto-generated method stub
		builder.delete(0, builder.length()).append("cd");
		
	}

	private static void changeString(String str) {
		// TODO Auto-generated method stub
		str = "cd";
		
	}

}
