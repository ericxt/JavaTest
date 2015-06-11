package moreAboutJava;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExceptionTest {
	private static Timer timer = new Timer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			launchTimer();
			Thread.sleep(5000);
			addTimer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addTimer() {
		// TODO Auto-generated method stub
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("add timer");
			}
		}, 1000, 1000);

	}

	private static void launchTimer() {
		// TODO Auto-generated method stub
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				throw new RuntimeException();

			}
		}, 3000, 500);

	}

}
