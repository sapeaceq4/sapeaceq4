package com.sapient.ACE.ThreadPool;

import java.util.concurrent.BlockingQueue;

public class MyThread extends Thread{

	BlockingQueue tasks=null;
	boolean stop=false;
	
	public MyThread(BlockingQueue tasks) {
		this.tasks=tasks;
	}
	
	@Override
	public void run() {
		while(!stop){
			Runnable r;
			try {
				r = (Runnable) tasks.take();
				r.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public synchronized void doStop(){
        stop = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }
	
	
}		
