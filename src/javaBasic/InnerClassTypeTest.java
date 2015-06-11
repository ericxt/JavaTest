package javaBasic;

class Outer {
	private String x = "outer";

	public void makeInner() {
		MemberInner inner = new MemberInner();
		inner.seeOuter();
	}

	public void doStuff() {
		class MethodLocalInner {
			public void seeOuter() {
				System.out.println("x is " + x);
				System.out.println("method local inner class reference is "
						+ this);
				System.out.println("outer class reference is " + Outer.this);
			}
		}

		MethodLocalInner localInner = new MethodLocalInner();
		localInner.seeOuter();
	}

	static class StaticInner {
		void method() {
			System.out.println("static inner class reference is " + this);
		}
	}

	class MemberInner {
		public void seeOuter() {
			System.out.println("x is " + x);
			System.out.println("member inner class reference is " + this);
			System.out.println("outer class reference is " + Outer.this);
		}
	}

}

public class InnerClassTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer.StaticInner().method();

		Outer outer = new Outer();
		outer.makeInner();

		outer.doStuff();

	}

}
