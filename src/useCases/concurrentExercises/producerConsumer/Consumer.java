package useCases.concurrentExercises.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable{
	
	private ArrayBlockingQueue<String> blockingQueue;
	
	public Consumer(ArrayBlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String element = blockingQueue.take();
				System.out.println("-->"+element);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
