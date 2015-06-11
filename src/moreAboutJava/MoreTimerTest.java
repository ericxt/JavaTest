package moreAboutJava;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
	private int i;

	MyTask(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i + ":" + new Date());

	}

}

public class MoreTimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		for (int i = 0; i < 5; i++) {
			System.out.println("Task " + i + " : " + new Date());
			timer.schedule(new MyTask(i), (10 - i) * 1000);
		}

	}

}
