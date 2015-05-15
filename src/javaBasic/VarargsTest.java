package javaBasic;

public class VarargsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("a");
		print("a", "b");
		print("a", "b", "c");

	}
	
	// varargs : ...
	public static void print(String ... s) {
		for (String str : s) {
			System.out.println(str);
		}
	}

}
