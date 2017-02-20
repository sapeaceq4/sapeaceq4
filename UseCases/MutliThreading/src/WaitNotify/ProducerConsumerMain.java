package WaitNotify;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {
	public static void main(String args[]) {
		System.out.println("Wait Notify-");
		List<Integer> ar = new ArrayList<>();
		int maxSize = 10;
		Thread producer = new Producer(ar, maxSize, "PRODUCER");
		Thread consumer = new Consumer(ar, maxSize, "CONSUMER");
		producer.start();
		consumer.start();
	}
}
