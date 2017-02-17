import java.util.concurrent.BlockingQueue;



public class MyThread extends Thread {

	String name;
	BlockingQueue queue ;
	
	public MyThread(String string,BlockingQueue queue) {
		name=string;
		this.queue=queue;
	}

	public void run()
	{
		while(true)
		{
			try {
				System.out.println("Name of Thread is " + Thread.currentThread().getName());
				Runnable r=(Runnable) queue.take();
				r.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
