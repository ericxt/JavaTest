package javaBasic;

public class StringCompareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "test";
		String str2 = new String("test");
		
		// compare the reference
		System.out.println("use == : " + (str1 == str2));
		
		// compare the value
		System.out.println("use equals() : " + str1.equals(str2));

	}

}
