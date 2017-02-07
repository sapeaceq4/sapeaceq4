package data.session.usecases;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {
	
	private CountDownLatch latch;
	
	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println(Thread.currentThread().getName() +
					" latch at count "+latch.getCount());

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println(Thread.currentThread().getName() +
					" latch at count "+latch.getCount());

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println(Thread.currentThread().getName() +
					" latch at count "+latch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
