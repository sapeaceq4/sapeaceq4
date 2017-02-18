package data.session.usecases.usecase3;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomProducer implements Runnable {

	private final List<Integer> sharedQueue;

	private final int SIZE;

	CustomProducer(List<Integer> sharedQueue, int size) {
		this.sharedQueue = sharedQueue;	
		this.SIZE = size;
	}

	@Override
	public void run() {
			for (int i = 0; i < 15; i++) {
				try {
					produce(i);
				} catch (InterruptedException ex) {
					Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
	}

	private void produce(int i) throws InterruptedException {

		//wait if queue is full
		
		synchronized (sharedQueue) {
			while (sharedQueue.size() == SIZE) {
				System.out.println("Queue is full " + Thread.currentThread().getName()
						+ " is waiting , size: " + sharedQueue.size());
				sharedQueue.wait();
				//sharedQueue.notifyAll();
			}
			//producing element and notify consumers
			synchronized (sharedQueue) {
				sharedQueue.add(i);
				System.out.println("Produced: " + i);
				sharedQueue.notify();
			}

		}
	}
}
