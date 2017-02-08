package com.multithread.phaser;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Tourist implements Runnable{

	private Phaser phaser;
	
	public Tourist(Phaser phaser){
		this.phaser = phaser;
	}
	
	@Override
	public void run(){
		System.out.println("Check in for journey to everest "+Thread.currentThread().getName()+", "+ new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println("Processing for base camp "+Thread.currentThread().getName()+", "+new Date());
		wait(10);
		System.out.println("Reached base camp "+Thread.currentThread().getName()+", "+new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println("Starting jaourney to point G4"+ Thread.currentThread().getName()+", "+new Date());
		wait(10);
		System.out.println("Reached point g4 "+Thread.currentThread().getName()+", "+new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println("start mounten journey "+Thread.currentThread().getName()+", "+new Date());
		wait(10);
		System.out.println("Finished!! "+Thread.currentThread().getName()+", "+new Date());
	}
	
	private void wait(int time){
		long duration = (long)(Math.random()*time);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}