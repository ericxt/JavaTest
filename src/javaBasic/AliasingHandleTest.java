package javaBasic;

class C {
	public void methodParent() {
		System.out.println("method in paren[t");
	}
}

class D extends C {
	public void methodParent() {
		System.out.println("override method in child");
	}
	
	public void methodChild() {
		System.out.println("method in child");
	}
}

public class AliasingHandleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D[] b = new D[10];
		C[] a = b;
		
		// if new C(), exception throwed
//		a[0] = new C();
		
		// a[]'s actual object type is D()
		a[0] = new D();
		b[0].methodParent();

	}

}
