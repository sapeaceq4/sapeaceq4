package data.session.usecases.usecase7;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounter {
	
	private static AtomicInteger count = new AtomicInteger(0);


	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		t1.start();
		t2.start();
	}
	
	static class MyRunnable implements Runnable {

		private int myCounter;

		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				myCounter = count.incrementAndGet();
				System.out.println("Thread "+Thread.currentThread().getId()+ " count :" +myCounter);
			}
		}

	}


}
