package moreAboutJava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
	private static ScheduledExecutorService scheduExec = Executors
			.newScheduledThreadPool(1);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchTask();
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addTask();

	}

	private static void addTask() {
		// TODO Auto-generated method stub
		Runnable task = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in addTask()");

			}
		};
		scheduExec.scheduleWithFixedDelay(task, 1000, 1000,
				TimeUnit.MILLISECONDS);

	}

	private static void launchTask() {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("runtime exception");
				throw new RuntimeException();

			}
		};
		// TODO Auto-generated method stub
		scheduExec.scheduleAtFixedRate(task, 1000 * 5, 1000 * 10,
				TimeUnit.MILLISECONDS);

	}

}
