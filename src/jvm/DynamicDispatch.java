package jvm;

public class DynamicDispatch {
	static abstract class Human {
		protected abstract void sayHello();
	}
	
	static class Man extends Human {

		@Override
		protected void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("Hello Man");
		}
		
	}
	
	static class Woman extends Human {

		@Override
		protected void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("Hello Woman");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		
		man = new Woman();
		man.sayHello();
	}

}
