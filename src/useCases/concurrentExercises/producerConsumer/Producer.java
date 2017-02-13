package useCases.concurrentExercises.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

public class Producer implements Runnable{
	
	private ArrayBlockingQueue<String> blockingQueue;
	
	public Producer(ArrayBlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				blockingQueue.put("testString"+1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
