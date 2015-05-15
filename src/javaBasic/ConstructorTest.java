package javaBasic;

class Super {
	public String s = "Super";
	// method 1
	public Super() {
		System.out.println("construcing >>> Super()");
	}
	
	// method 2 : remove the Super(String)
	public Super(String s) {
		System.out.println("constructing >>> Super(String)" + s);
	}
}

class Sub extends Super {
	public String s = "Sub";
	public Sub() {
		// method 3
		super("in Sub()");
		System.out.println("constructing >>> Sub()");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub sub1 = new Sub();
		Super sub2 = new Sub();
		
		System.out.println(sub1.s);
		System.out.println(sub2.s);
	}

}
