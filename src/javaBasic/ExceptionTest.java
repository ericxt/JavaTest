package javaBasic;

class MyException extends Exception {
	
}

public class ExceptionTest {
	private static Exception exception;
	private static MyException myException;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// Integer, Double : developed by different persons
		
		// java.lang.NumberFormationException
//		Integer.parseInt(null);
		
		// java.lang.NullPointerException
//		Double.parseDouble(null);
		
//		callDoOne();
		callMyDoOne();

	}

	private static void callMyDoOne() throws Exception {
		// TODO Auto-generated method stub
		myDoOne();
		throw exception;
		
	}

	private static void myDoOne() throws MyException {
		// TODO Auto-generated method stub
		throw myException;
		
	}

	private static void callDoOne() throws Exception {
		// TODO Auto-generated method stub
		doOne();
		
	}

	private static void doOne() throws Exception {
		// TODO Auto-generated method stub
		exception = new Exception("exception test");
		throw exception;
		
	}

}
