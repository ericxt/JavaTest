package interviewKeepsake;

public class StaticIPlusPlus {
	static {
		int x = 5;	// x is local parameter.
	};
	static int x, y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		x--;
		myMethod();
		System.out.println(x + y ++ + x);
	}

	private static void myMethod() {
		// TODO Auto-generated method stub
		y = x++ + ++x;
		
	}

}
