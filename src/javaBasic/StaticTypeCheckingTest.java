package javaBasic;

class TypeA {
	TypeA me() {
		return this;
	}
	
	public void doA() {
		System.out.println("doA in typea");
	}
}

class TypeB extends TypeA {
	public void doA() {
		System.out.println("doA in typeb");
	}
	public void doB() {
		System.out.println("doB");
	}
}

class TypeC extends TypeA {
	public void doBad() {
		System.out.println("doBad");
	}
}

public class StaticTypeCheckingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// illegal
//		new TypeB().me().doB();
		
		// print typeb
		System.out.println(new TypeB().me());
		
		// cast to typeb
		((TypeB)new TypeB().me()).doB();
		
		new TypeB().me().doA();
		((TypeA)new TypeB().me()).doA();
		
		// run time exception
		((TypeC)new TypeB().me()).doBad();

	}

}
