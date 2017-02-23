package useCases.threadpool.producerConsumer;

import useCases.threadpool.BlockingQueue;

public class ProducerConsumerTest {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> testQueue = new BlockingQueue<>(2);
		Producer pd = new Producer(testQueue);
		Consumer cm = new Consumer(testQueue);
		new Thread(pd).start();
		new Thread(cm).start();
	}

}
