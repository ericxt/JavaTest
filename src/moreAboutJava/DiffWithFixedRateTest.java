package moreAboutJava;

import java.util.Date;
import java.util.Timer;

public class DiffWithFixedRateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		System.out.println("begin : " + new Date());
		timer.schedule(new MyTask(0), 1000, 2000);
		timer.scheduleAtFixedRate(new MyTask(1), 1000, 2000);
		

	}

}
