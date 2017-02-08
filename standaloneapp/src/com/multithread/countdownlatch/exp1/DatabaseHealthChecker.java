package com.multithread.countdownlatch.exp1;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {

	public DatabaseHealthChecker(CountDownLatch latch) {
		super(latch, "DB");
	}
	@Override
	public void verifyservice() {

			System.out.println("Checking.. "+this.get_serviceName());
			
			try {
				Thread.sleep(2500);
			} catch (Exception e) {
				
			}
			
			System.out.println(this.get_serviceName()+" is up ");
	}
}
