package App;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PcArrayBlockingQueue {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(
			5);

	public static void main(String[] args) {
		Random random = new Random();

		Runnable addRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("adding");
				queue.add(random.nextInt(20));
			}
		};

		Runnable takeRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("removing --- " + queue.take());
					Thread.sleep(2000);
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
