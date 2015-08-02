package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class DispatchRuleTest {
	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}

	class Father extends GrandFather {
		void thinking() {
			System.out.println("i am father");
		}
	}

	class Son extends Father {
		void thinking() {
			MethodType mt = MethodType.methodType(void.class);
			try {
				MethodHandle mh = lookup().findSpecial(GrandFather.class,
						"thinking", mt, getClass());
				mh.invoke(this);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new DispatchRuleTest().new Son()).thinking();
		// new DispatchRuleTest().new GrandFather().thinking();

	}

}
