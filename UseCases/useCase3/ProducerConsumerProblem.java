package data.session.usecases.usecase3;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		List<Integer> sharedQueue = new ArrayList<>();
		int size = 4;
		Thread prodThread = new Thread(new CustomProducer(sharedQueue, size), "Producer");
		Thread consThread = new Thread(new CustomConsumer(sharedQueue, size), "Consumer");
		prodThread.start();
		consThread.start();
	}
}
