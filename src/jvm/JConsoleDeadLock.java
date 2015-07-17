package jvm;

public class JConsoleDeadLock {
	static class SynAddRunable implements Runnable {
		int a, b;

		public SynAddRunable(int a, int b) {
			// TODO Auto-generated constructor stub
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);

				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}

	}

}
