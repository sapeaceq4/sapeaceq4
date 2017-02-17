
public class ThreadTest {
	
	public static void main(String[] args) {
		
		CustomPool customThreadPool = new CustomPool(5);
		
		for(int i=0;i<5;i++)
		{
			Task task1=new Task();
			task1.name="Task " + i;
			System.out.println("Name of Task created is " + task1.getName() );
			customThreadPool.execute(task1);
		}
		
		
		
	}

}
