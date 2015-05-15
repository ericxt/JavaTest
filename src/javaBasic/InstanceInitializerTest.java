package javaBasic;

public class InstanceInitializerTest {
	String s = "abc";
	
	public InstanceInitializerTest() {
		System.out.println("constructor");
	}
	
	static {
		System.out.println("static initializer");
	}
	
	{
		System.out.println("instance initializer");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InstanceInitializerTest();
		new InstanceInitializerTest();

	}

}
