package javaBasic;

class Orange {
	public String color = "red";
}

public class PassByValueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ab";
		String b = "cd";
		int x = 1;
		int y = 2;
		
		Orange apple = new Orange();
		System.out.println(apple.color);
		changeColor(apple);
		System.out.println("after change : " + apple.color);
		
		swap(a, b);
		System.out.println("a = " + a + "; b = " + b);
		swap(x, y);
		System.out.println("x = " + x + "; y = " + y);

	}

	private static void changeColor(Orange apple) {
		// TODO Auto-generated method stub
		apple.color = "green";
		
	}

	private static void swap(int x, int y) {
		// TODO Auto-generated method stub
		int temp = x;
		x = y;
		y = temp;
		System.out.println("in swap : x = " + x + "; y = " + y);
		
	}

	private static void swap(String a, String b) {
		// TODO Auto-generated method stub
		String temp = a;
		a = b;
		b = temp;
		System.out.println("in swap : a = " + a + "; b = " + b);
		
	}

}
