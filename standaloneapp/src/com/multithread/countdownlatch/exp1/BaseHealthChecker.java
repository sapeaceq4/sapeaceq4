package com.multithread.countdownlatch.exp1;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable {

	private CountDownLatch _latch;
	private String _serviceName;
	private boolean _serviceUp;
	
	public abstract void verifyservice();
	
	public BaseHealthChecker(CountDownLatch latch,String serviceName){
		this._latch = latch;
		this._serviceName = serviceName;
		this._serviceUp = false;
	}
	
	public void run(){
		try {
			verifyservice();
			_serviceUp = true;
		} catch (Exception e) {
			_serviceUp =false;
		}finally{
			if(_latch!=null){
				_latch.countDown();
			}
		}
	}

	public String get_serviceName() {
		return _serviceName;
	}

	public boolean is_serviceUp() {
		return _serviceUp;
	}
	
	
}
