package interviewKeepsake;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DataTypeSize {
	private static Runtime rTime = Runtime.getRuntime();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// the size of primitive data type
		System.out.println("byte >>> bits : " + Byte.SIZE + " , bytes : "
				+ Byte.SIZE / 8);
		System.out.println("char >>> bits : " + Character.SIZE + " , bytes : "
				+ Character.SIZE / 8);
		System.out.println("short >>> bits : " + Short.SIZE + " , bytes : "
				+ Short.SIZE / 8);
		System.out.println("int >>> bits : " + Integer.SIZE + " , bytes : "
				+ Integer.SIZE / 8);
		System.out.println("long >>> bits : " + Long.SIZE + " , bytes : "
				+ Long.SIZE / 8);
		System.out.println("float >>> bits : " + Float.SIZE + " , bytes : "
				+ Float.SIZE / 8);
		System.out.println("double >>> bits : " + Double.SIZE + " , bytes : "
				+ Double.SIZE / 8);

		calSize();

	}

	private static void calSize() {
		// TODO Auto-generated method stub
		runGC();

		long heap1 = 0;
		final int count = 100000;
		Object[] objs = new Object[count];

		for (int i = -1; i < count; i++) {
			Object obj = null;
//			obj = new Object();
//			obj = new Integer(i);
//			obj = new Double(i);
//			obj = new Long(i);
//			obj = new Float(i);
			obj = new String();

			if (i < 0) {
				obj = null;
				runGC();
				heap1 = usedMemory();
			} else {
				objs[i] = obj;
			}
		}

		runGC();
		long heap2 = usedMemory();
		final int size = (int) Math.round((heap2 - heap1) / (double) count);
		
		System.out.println("heap1 = " + heap1 + " ; heap2 = " + heap2);
		System.out.println("heap2 - heap1 = " + (heap2 - heap1) + " ; "
				+ objs[0].getClass().getSimpleName() + " size = " + size);
		
		for (int i = 0; i < count; i++) {
			objs[i] = null;
		}
		objs = null;
		runGC();

	}

	private static void runGC() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			long usedMem1 = usedMemory();
			long usedMem2 = Long.MAX_VALUE;

			for (int j = 0; (usedMem1 < usedMem2) && (j < 500); j++) {
				rTime.runFinalization();
				rTime.gc();
				Thread.yield();

				usedMem2 = usedMem1;
				usedMem1 = usedMemory();
			}
		}

	}

	private static long usedMemory() {
		// TODO Auto-generated method stub
		return rTime.totalMemory() - rTime.freeMemory();
	}

}
