package jvm;

import java.util.ArrayList;

public class JConsoleMemMonitoring {
	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		while (true) {
		fillHeap(1000);
		System.gc();
		}

	}

	private static void fillHeap(int num) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
//		System.gc();

	}

}
