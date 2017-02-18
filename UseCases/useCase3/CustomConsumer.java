package data.session.usecases.usecase3;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomConsumer implements Runnable {
	
	private final List<Integer> sharedQueue;

	private final int SIZE;
	
	CustomConsumer(List<Integer> sharedQueue, int size) {
		this.sharedQueue = sharedQueue;	
		this.SIZE = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
				//Thread.sleep(50);
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
			}		
		}
	}
	
	private void consume() throws InterruptedException {

		synchronized (sharedQueue) {
			while (sharedQueue.size() == 0) {
				System.out.println("Queue is empty " + Thread.currentThread().getName()
						+ " is waiting , size: " + sharedQueue.size());
				sharedQueue.wait();
			}

			synchronized (sharedQueue) {
				System.out.println("consumed.. "+sharedQueue.remove(0));
				sharedQueue.notify();
			}
		}
	}
}
