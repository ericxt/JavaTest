package jvm;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class InvokeDynamicTest {

	public static void main(String[] args) throws NoSuchMethodException,
			IllegalAccessException, Throwable {
		// TODO Auto-generated method stub
		INDY_BootstrapMethod().invokeExact("ericxt");
	}

	public static void testMethod(String s) {
		System.out.println("hello String : " + s);
	}

	public static CallSite BootstrapMethod(MethodHandles.Lookup lookup,
			String name, MethodType mt) throws NoSuchMethodException,
			IllegalAccessException {
		return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class,
				name, mt));
	}

	private static MethodType MT_BootstrapMethod() {
		return MethodType
				.fromMethodDescriptorString(
						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
						null);
	}

	private static MethodHandle MH_BootstrapMethod()
			throws NoSuchMethodException, IllegalAccessException {
		return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod",
				MT_BootstrapMethod());
	}

	private static MethodHandle INDY_BootstrapMethod()
			throws NoSuchMethodException, IllegalAccessException, Throwable {
		CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(
				lookup(),
				"testMethod",
				MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",
						null));
		return cs.dynamicInvoker();
	}

}
