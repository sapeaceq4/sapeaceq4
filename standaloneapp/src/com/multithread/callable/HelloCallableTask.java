package com.multithread.callable;

import java.util.Date;
import java.util.concurrent.Callable;

public class HelloCallableTask implements Callable<String>{

	private String name;
	
	public HelloCallableTask(String name) {
		this.name=name;
	}
	
	@Override
	public String call() throws Exception {
		return "this is "+name+" "+new Date();
	}

}
