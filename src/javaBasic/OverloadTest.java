package javaBasic;

class A {
	public void foo(int i) {
		System.out.println("int");
	}

	public void foo(String str) {
		System.out.println("String");
	}
}

class B extends A {
	public void foo(int i) {
		System.out.println("overload int");
	}
}

public class OverloadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.foo(123);
		a.foo("test");
		
		// determined by real type
		A b = new B();
		b.foo(123);
		
		B c = new B();
		c.foo(123);

	}

}
