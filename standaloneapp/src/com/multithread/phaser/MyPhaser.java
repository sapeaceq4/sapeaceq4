package com.multithread.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

	public static void main(String[] args) {
		Phaser phaser = new Phaser();
		Tourist[] tourist = new Tourist[3];
		
		for(int i=0;i<tourist.length;i++){
			tourist[i] = new Tourist(phaser);
			phaser.register();
			
			System.out.println("registered!");
		}
		
		Thread[] t = new Thread[tourist.length];
		for(int i=0;i<tourist.length;i++){
			t[i] = new Thread(tourist[i]+" tourist "+i);
			t[i].start();
			
			System.out.println("Thread started!!");
		}
		
		System.out.println("finished "+phaser.isTerminated());
		
	}
	
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		System.out.println("on advance called");
		return super.onAdvance(phase, registeredParties);
	}
	
}
