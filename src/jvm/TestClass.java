package jvm;

public class TestClass {
	void foo(Object f) {
		synchronized (f) {
			bar();
		}
	}

	private void bar() {
		// TODO Auto-generated method stub
		
	}

}
