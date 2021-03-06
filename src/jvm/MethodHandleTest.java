package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
	static class ClassA {
		public void println(String s) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {
		// TODO Auto-generated method stub
//		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out
//				: new ClassA();
		Object obj = new ClassA();

		getPrintlnMH(obj).invokeExact("methodHandleTest");

	}

	private static MethodHandle getPrintlnMH(Object receiver)
			throws NoSuchMethodException, IllegalAccessException {
		MethodType mt = MethodType.methodType(void.class, String.class);
		return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(
				receiver);
	}

}
