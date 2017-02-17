package Concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue<String> bq = null;
	
	public Consumer(BlockingQueue<String> bq){
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(bq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
