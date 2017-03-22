package Classes;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBlockingQueue {

	public static void main(String[] args) throws Exception {

		LinkedBlockingQueue queue = new LinkedBlockingQueue(5);
		Random random = new Random();

		Runnable addRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					Integer i = random.nextInt(20);
					System.out.println("adding   --- " + i);
					queue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable takeRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("removing --- " + queue.take());
					//Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		ExecutorService exec = Executors.newFixedThreadPool(20);

		while (true) {
			exec.submit(addRunnable);
			exec.submit(takeRunnable);
		}

	}

}
