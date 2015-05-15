package javaBasic;

class Add extends Thread {
	int value;
	
	public void run() {
		value = 1 + 2;
	}
}

class Mult extends Thread {
	int value;
	
	public void run() {
		value = 1 * 2;
	}
}

public class MultiThreadCalculationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add add = new Add();
		Mult mult = new Mult();
		
		add.start();
		mult.start();
		
		try {
			add.join();
			mult.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double result = (double)mult.value / add.value;
		System.out.println(result);

	}

}
