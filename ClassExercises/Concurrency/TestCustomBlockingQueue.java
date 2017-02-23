package ThreadPractice;

public class TestCustomBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomBlockingQueue cbq = new CustomBlockingQueue(7);
		
		Thread t1 = new Thread(){
			//volatile int i = 0;
			@Override
			public void run(){
				
				try {
					
					cbq.put("1");
					cbq.put("2");
					cbq.put("3");
					cbq.put("4");
					cbq.put("5");
					cbq.put("6");
					cbq.put("7");
					cbq.put("8");
					cbq.put("9");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run(){
				System.out.println(cbq.take());
				System.out.println(cbq.take());
				System.out.println(cbq.take());
				System.out.println(cbq.take());
				System.out.println(cbq.take());
				System.out.println(cbq.take());
				//System.out.println(cbq.take());
			}
		};
		
		
		t1.start();
		t2.start();
		

	}

}
