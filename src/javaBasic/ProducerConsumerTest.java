package javaBasic;

import java.util.Date;
import java.util.Vector;

class Producer extends Thread {
	static final int MAXQUEUE = 5;
	private Vector<String> messages = new Vector<String>();

	public void run() {
		while (true) {
			try {
				putMessage();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private synchronized void putMessage() throws InterruptedException {
		// TODO Auto-generated method stub
		if (messages.size() == MAXQUEUE) {
			wait();
		}
		messages.addElement(new Date().toString());
		System.out.println("put message");
		notify();
	}

	public synchronized String getMessage() throws InterruptedException {
		notify();
		if (messages.size() == 0) {
			wait();
		}
		String message = messages.firstElement();
		messages.removeElement(message);
		return message;
	}
}

class Consumer extends Thread {
	private Producer producer;

	public Consumer(Producer producer) {
		this.producer = producer;
	}

	public void run() {
		while (true) {
			String message;
			try {
				message = producer.getMessage();
				System.out.println("consumer >>> " + message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer producer = new Producer();
		producer.start();

		new Consumer(producer).start();

	}

}
