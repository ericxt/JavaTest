package interviewKeepsake;

class Base {
	public String getFields() {
		String name = "Base";
		return name;
	}

}

class Agg extends Base {
	public String getFields() {
		System.out.println(this);
		String name = "Agg";
		return name;
	}
}

final class test {
	int i = 7;
	void f() {
		System.out.println(i);
	}
}

public class Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base a = new Agg();
		System.out.println(((Agg)a).getFields());
		System.out.println(a.getFields());
		System.out.println(((Base)a).getFields());
		
		test test = new test();
		test.i  = 40;
		test.f();
		
	}
}
