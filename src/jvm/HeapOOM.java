package jvm;

import java.util.ArrayList;

public class HeapOOM {
	static class OOMObject {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}

}
