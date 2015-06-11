package javaBasic;

class ClassA {
	public void method() {
		System.out.println("in ClassA");
	}
}

public class ClassLoadedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("class loader test");
		ClassA classA = new ClassA();
		classA.method();

	}

}
