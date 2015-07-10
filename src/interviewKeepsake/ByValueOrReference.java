package interviewKeepsake;

class Value {
	public int i = 15;
}

public class ByValueOrReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByValueOrReference test = new ByValueOrReference();
		test.first();

	}

	private void first() {
		// TODO Auto-generated method stub
		int i = 5;
		Value v = new Value();
		v.i = 25;
		System.out.println(v);
		second(v, i);
		System.out.println(v);
		System.out.println(v.i);
		
	}

	private void second(Value v, int i) {
		// TODO Auto-generated method stub
		i = 0;
		v.i = 20;
		Value val = new Value();
		v = val;
		System.out.println(v);
		System.out.println(v.i + " " + i);
		
	}

}
