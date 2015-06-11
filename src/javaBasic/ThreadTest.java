package javaBasic;

class ThreadA implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		
	}
	
}

class ThreadB implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		new ThreadA().run();
		new Thread(new ThreadA(), "name_thread2").run();
		new Thread(new ThreadA(), "name_thread3").start();
		
	}
	
}

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new ThreadB(), "name_thread1").start();

	}

}
