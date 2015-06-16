package timerTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimerTest {
	static int mCount = 0;

	// static Logger logger = LogManager.getLogger(TimerTest.class.getName());

	private static void showTimer() throws Exception {
		int i = 0;
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 9, 0, 0);
		Date date = calendar.getTime();
		System.out.println(date);

		int period = 24 * 60 * 60 * 1000;
		Timer timer = new Timer();
		TimerTask task = new TimerTestTask(timer, "task" + System.currentTimeMillis());
//		timer.schedule(task, 1000, period);
		timer.schedule(task, date, period);
//		while (true) {
//			while (i < 5) {
//				Thread.sleep(1000);
//				i++;
//			}
//			Timer newTimer = new Timer();
//			newTimer.schedule(
//					new TimerTestTask(newTimer, "newTask"
//							+ System.currentTimeMillis()), 1000, period);
//			mCount++;
//			
//			i = 0;
//		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		showTimer();
	}

}

class TimerTestTask extends TimerTask {
	int count = 0;
	static Logger logger = LogManager.getLogger(TimerTest.class.getName());
	Timer timer = new Timer();
	String taskName;

	public TimerTestTask() {
		// TODO Auto-generated constructor stub
	}

	TimerTestTask(Timer timer, String taskName) {
		this.timer = timer;
		this.taskName = taskName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		if (count == 0) {
//			logger.info("timer start schedule");
//		}
//		++count;
//		System.out.println("time : " + new Date() + "  taskName: " + taskName
//				+ " count: " + count);
//		logger.info("time : " + new Date() + "  taskName: " + taskName
//				+ "  count: " + count);
//		if (count == 2) {
//			timer.cancel();
//			logger.info("timer cancel");
//		}
		
		System.out.println("run");
		count++;
		logger.info("time : " + new Date() + "  taskName: " + taskName
				+ "  count: " + count);
		if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == 20) {
			try {
				logger.info("sleep 13 hours");
				Thread.sleep(13 * 60 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
