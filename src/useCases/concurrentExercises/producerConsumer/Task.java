package useCases.concurrentExercises.producerConsumer;

import java.util.concurrent.Callable;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("executing Task ");
		
	}

}
