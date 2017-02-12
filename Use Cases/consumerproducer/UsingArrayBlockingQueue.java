package com.ace.consumerproducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingArrayBlockingQueue {

	public static void main(String args[]){
		  
	     BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(9);
	 
	     Thread prodThread = new Thread(new Producer(sharedQueue));
	     Thread consThread = new Thread(new Consumer(sharedQueue));

	     prodThread.start();
	     consThread.start();
	    }
	 
	}

	class Producer implements Runnable {

	    private final BlockingQueue sharedQueue;

	    public Producer(BlockingQueue sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }

	    @Override
	    public void run() {
	        for(int i=0; i<9; i++){
	            try {
	                System.out.println("Produced: " + i);
	                sharedQueue.put(i);
	            } catch (InterruptedException ex) {
	                
	            }
	        }
	    }

	}

	class Consumer implements Runnable{

	    private final BlockingQueue sharedQueue;

	    public Consumer (BlockingQueue sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }
	  
	    @Override
	    public void run() {
	        while(true){
	            try {
	                System.out.println("Consumed: "+ sharedQueue.take());
	            } catch (InterruptedException ex) {
	            }
	        }
	    }

}
