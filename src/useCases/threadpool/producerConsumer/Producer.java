package useCases.threadpool.producerConsumer;

import useCases.threadpool.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Integer> listProducers;
	
	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.listProducers = blockingQueue;
	}
	

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			try {
				listProducers.enQueue(i);
//				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("enqueued element "+i);
		}
	}
}
