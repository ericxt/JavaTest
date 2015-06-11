package timerTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	static int count = 0;
	
	private static void showTimer() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				++count;
				System.out.println("time : " + new Date() + "  count: " + count);
			}
		};
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day + 1, 9, 0, 0);
		Date date = calendar.getTime();
		Timer timer = new Timer();
		System.out.println(date);
		
		int period = 5 * 60 * 1000;
		timer.schedule(task, date, period);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showTimer();
	}

}
