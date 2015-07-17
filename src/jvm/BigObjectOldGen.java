package jvm;

public class BigObjectOldGen {
	private static int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPretenureSizeThreshold();

	}

	private static void testPretenureSizeThreshold() {
		// TODO Auto-generated method stub
		byte[] allocation;
		allocation = new byte[4 * _1MB];
		
	}

}
