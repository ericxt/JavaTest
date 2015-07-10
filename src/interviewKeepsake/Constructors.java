package interviewKeepsake;

class X {
	Y y = new Y();
	
	X() {
		System.out.println("X");
	}
}

class Y {
	Y() {
		System.out.println("Y");
	}
}

public class Constructors extends X {
	Y y = new Y();
	
	public Constructors() {
		// TODO Auto-generated constructor stub
		System.out.println("Z");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Constructors();
	}

}
