import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {

	BlockingQueue<Integer> queue;
    String name; 
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		consume();
		
	}

	private void consume() {
		
		for(int i=0;i<5;i++)
		{
			try {
				System.out.println("Consumer on work " + name);
				System.out.println("Value taken from the queue " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
public String getName() {
		
		return name;
	}

}
