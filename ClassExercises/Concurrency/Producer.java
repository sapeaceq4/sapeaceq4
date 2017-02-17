package Concurrency;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<String> bq = null;
	
	public Producer (BlockingQueue<String> bq){
		this.bq = bq;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			bq.put("I am the object");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
