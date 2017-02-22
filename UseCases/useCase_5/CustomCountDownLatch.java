package ThreadPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomCountDownLatch {

	
	private AtomicInteger count = new AtomicInteger(0);

	public CustomCountDownLatch(int initialVal) {
		count.set(initialVal);
	}

	public void await() throws InterruptedException {
		if (count.get() == 0) {
			// Let the thread go ahead
			return;
		} else {
			synchronized (this) {
				this.wait();
			}

		}

	}

	public void countDown() {
		// System.out.println("value of count is"+ count.get());
		
		if (count.decrementAndGet() == 0) {
			synchronized (this) {
				this.notifyAll();
			}

		}
	}

}
