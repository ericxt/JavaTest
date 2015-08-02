package jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {

		@Override
		public void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("Hello World");
		}

	}

	static class DynamicProxy implements InvocationHandler {
		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass()
					.getClassLoader(), originalObj.getClass().getInterfaces(),
					this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			// TODO Auto-generated method stub
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}

}
