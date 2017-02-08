package com.multithread.practice;

public class B implements Runnable {

	@Override
	public void run() {
		System.out.println("Class: "+Thread.currentThread().getClass());
		new A().run();
		new Thread(new A(),"T2").start();
		new Thread(new A(),"T3").run();
	}

}
