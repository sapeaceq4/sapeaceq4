import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {

	BlockingQueue<Integer> queue;
    String name;
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		produce();
	}
   
	public void produce()
	{
		for(int i=0;i<5;i++)
		{
			try {
				System.out.println("Producer on work " + name);
				queue.put(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread is interrupted" + Thread.currentThread().getName());
			}
		}
	}

	public String getName() {
		
		return name;
	}
	 
			
}
