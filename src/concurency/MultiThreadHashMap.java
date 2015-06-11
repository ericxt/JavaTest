package concurency;

import java.util.HashMap;
import java.util.UUID;

public class MultiThreadHashMap {
	static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final HashMap<String, String> map = new HashMap<String, String>(2);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							map.put(UUID.randomUUID().toString(), "");
							System.out.println("Thread " + ++count);

						}
					}, "ftf" + i).start();
				}

			}
		}, "ftf");

		t.start();
		t.join();

	}

}
