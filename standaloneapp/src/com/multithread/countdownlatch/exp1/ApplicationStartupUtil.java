package com.multithread.countdownlatch.exp1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {

	private static List<BaseHealthChecker> _services;
	private static CountDownLatch _latch;

	public static boolean checkForExternalServices() throws Exception {
		_latch = new CountDownLatch(3);
		
		_services = new ArrayList<>();
		_services.add(new NetworkHealthChecker(_latch));
		_services.add(new DatabaseHealthChecker(_latch));
		
		Executor executor = Executors.newFixedThreadPool(_services.size());
		
		for(BaseHealthChecker b : _services){
			executor.execute(b);
		}
	
		_latch.await();
		
		for(BaseHealthChecker b : _services){
			if(!b.is_serviceUp()){
				return false;
			}
		}
		return true;
	}

}
