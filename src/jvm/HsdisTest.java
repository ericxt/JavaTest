package jvm;

public class HsdisTest {
	int a = 1;
	static int b = 2;

	public int sum(int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HsdisTest().sum(3);

	}

}
