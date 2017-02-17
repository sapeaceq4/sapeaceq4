import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class CustomPool {
	
	BlockingQueue queue=new LinkedBlockingQueue() ;
	
	CustomPool(int n)
	{
		for(int i=0;i<n;i++)
		{
			MyThread a = new MyThread("Thread" + i,queue);
			a.start();
		}
	}

	public void execute(Runnable task1) {
    
		try {
		    	queue.put(task1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
