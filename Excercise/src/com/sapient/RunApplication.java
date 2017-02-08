package com.sapient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunApplication {

	public static void main(String[] args) {
		/*Timer timer = new Timer();
		timer.schedule(new TestApplication(), 0, 5000);
		
		Executor fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 8; i++) {
			System.out.println("timer.....");
			TestApplication hTask = new TestApplication("task" + i);
			fixedThreadPool.execute(hTask);
		}*/
		
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(new TestApplication(), 2, 5, TimeUnit.SECONDS);
		
		
	}
}