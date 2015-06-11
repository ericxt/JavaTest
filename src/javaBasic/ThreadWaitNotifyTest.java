package javaBasic;

class ThreadCal extends Thread {
	public long total;

	public void run() {
		synchronized (this) {
			for (long i = 0; i < 10000000; i++) {
				total += i;
			}
			notify();
		}

	}
}

public class ThreadWaitNotifyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadCal b = new ThreadCal();
		b.start();
		synchronized (b) {
			try {
				System.out.println("wait for the completion of calculation");
				b.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(b.total);
		}


	}

}
