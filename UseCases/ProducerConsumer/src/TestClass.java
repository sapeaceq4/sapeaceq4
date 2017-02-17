import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class TestClass {

	public static void main(String[] args) {

		/*BlockingQueue queue = new ArrayBlockingQueue(1024);
	Producer prod=new Producer(queue);
	Consumer consumer=new Consumer(queue);
	Thread thread1=new Thread(prod);
	Thread thread2=new Thread(consumer);
	thread1.start();
	thread2.start();*/
		BlockingQueue queue = new ArrayBlockingQueue(30);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		for (int i = 0; i <= 10; i++) 
		{
			Producer prod=new Producer(queue);
			prod.name="Producer" + i;
			Consumer consumer=new Consumer(queue);
			consumer.name="Consumer" + i;
			//Task task = new Task("Task " + i);
			
			System.out.println("A new Producer has been added : " + prod.getName());
			System.out.println("A new Consumer has been added : " + consumer.getName());
			executor.execute(prod);
			executor.execute(consumer);
		}
		//executor.shutdown();
        
	}

}
