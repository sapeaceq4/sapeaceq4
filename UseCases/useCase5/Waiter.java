package data.session.usecases;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {

	private CountDownLatch latch;
	
	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");		
	}

}
