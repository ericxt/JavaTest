package jvm;

class SuperClass {
	static {
		System.out.println("SuperClass init");
	}
	
	public final static String HELLOWORLD = "helloworld";
}

class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init");
	}
}

public class NotInitialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(SubClass.value);
//		SuperClass[] sca = new SuperClass[10];
		System.out.println(SuperClass.HELLOWORLD);

	}

}
