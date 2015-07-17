package jvm;

public class LongLiveObjectOldGen {
	private static int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testTenuringThreshold();
		testTenuringThreshold2();

	}

	private static void testTenuringThreshold2() {
		// TODO Auto-generated method stub
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		allocation4 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
		
	}

	private static void testTenuringThreshold() {
		// TODO Auto-generated method stub
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
		
	}

}
