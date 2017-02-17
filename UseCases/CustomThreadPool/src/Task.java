
public class Task implements Runnable {

	String name;
	
	@Override
	public void run() {

		System.out.println("Task is running of thread" + Thread.currentThread().getName());
	}
	 String getName()
	 {
		 return name;
	 }
	

}
