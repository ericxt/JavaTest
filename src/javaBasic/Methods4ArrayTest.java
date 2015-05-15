package javaBasic;

import java.nio.ByteBuffer;

public class Methods4ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// convert an int to bytearray
		byte[] array = ByteBuffer.allocate(4).putInt(8).array();
		for (byte a : array) {
			System.out.format("0x%x ", a);
		}
		
	}

}
