package moreAboutJava;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SeveralTimerTest {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timerTest1();
		timerTest2();
//		timerTest3();
		timerTest4();

	}

	private static void timerTest4() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 20);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();

		Timer timer = new Timer();
		System.out.println("wait ....");
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("timertest4");

			}
		}, time, 24 * 60 * 60 * 1000);

	}

	private static void timerTest3() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("timertest3");

			}
		}, 2000, 1000);

	}

	private static void timerTest2() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (count < 5) {
					System.out.println("timertest2" + " " + ++count);
				} else {
					timer.cancel();
				}

			}
		}, 2000, 1000);

	}

	private static void timerTest1() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("timertest1");
				timer.cancel();

			}
		}, 2000);

	}

}
