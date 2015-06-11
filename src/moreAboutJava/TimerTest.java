package moreAboutJava;

import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {
	static int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this);
		System.out.println("mytimertask in run()" + " " + ++count);
	}

}

public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 1000, 2000);

		/**
		while (true) {
			try {
				System.out.println("input >>> ");
				int ch = System.in.read();
				System.out.println("ch >>> " + ch);
				if (ch - 'c' == 0) {
					System.out.println("timer cancel");
					timer.cancel();
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		**/

	}

}
