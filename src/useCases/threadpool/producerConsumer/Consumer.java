package useCases.threadpool.producerConsumer;

import useCases.threadpool.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue<Integer> listProducers;

	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.listProducers = blockingQueue;
	}


	@Override
	public void run() {
		System.out.println("started consumption");
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(2000);
				System.out.println("consumed element: "+listProducers.deQueue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
