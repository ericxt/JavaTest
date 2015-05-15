package javaBasic;

public class InnerClassTest {
	private int x = 10;
	
	static class StaticInnerClass {
		public void InnerMethod() {
			System.out.println("in staticinnerclass " + new InnerClassTest().x);
		}
	}
	
	class NoStaticInnerClass {
		public void InnerMethod() {
			System.out.println("in nostaticinnerclass " + x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClassTest test = new InnerClassTest();
		new StaticInnerClass().InnerMethod();
		(test.new NoStaticInnerClass()).InnerMethod();

	}

}
