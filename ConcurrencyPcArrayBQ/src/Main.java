import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(10);
		
		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);
		e.submit(producer);
		e.submit(consumer);
		
	}
}

class Producer implements Callable<BlockingQueue<String>> {
	
	BlockingQueue<String> bq;
	
	Producer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	
	@Override
	public BlockingQueue<String> call() throws Exception {
		while(true){
			System.out.println("bq.put(msg);");
			bq.put("msg");
		}
			
	}
	
}

class Consumer implements Callable<BlockingQueue<String>> {
	
	BlockingQueue<String> bq;
	
	Consumer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	
	@Override
	public BlockingQueue<String> call() throws Exception {
		while(true){
			System.out.println("bq.take();");
			bq.take();
		}
			
	}
	
}