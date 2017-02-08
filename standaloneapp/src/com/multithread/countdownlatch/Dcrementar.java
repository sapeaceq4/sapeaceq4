package com.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Dcrementar implements Runnable {

	CountDownLatch latch = null;
	
	public Dcrementar(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			latch.countDown();
			
			Thread.sleep(1000);
			latch.countDown();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
