package com.sapient.ace.producerconsuemt.blockingq;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<Integer> sharedQ;
	
	public Consumer(BlockingQueue<Integer> sharedQ) {
		super();
		this.sharedQ = sharedQ;
	}


	@Override
	public void run() {
		while(true){
			try {
                System.out.println("Consumed: "+ sharedQ.take());
            } catch (InterruptedException ex) {
            	ex.printStackTrace();
            }
		}
		
	}

}
