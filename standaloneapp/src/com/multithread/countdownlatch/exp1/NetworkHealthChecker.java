package com.multithread.countdownlatch.exp1;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker {

	public NetworkHealthChecker(CountDownLatch latch) {
		super(latch, "NW");
	}
	@Override
	public void verifyservice() {

			System.out.println("Checking.. "+this.get_serviceName());
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				
			}
			
			System.out.println(this.get_serviceName()+" is up ");
	}
}
