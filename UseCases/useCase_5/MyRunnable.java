package ThreadPractice;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable {
	
	private CustomCountDownLatch ccdl;

	public MyRunnable(CustomCountDownLatch ccdl1) {
		
		this.ccdl = ccdl1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
			System.out.println("running"+Thread.currentThread().getName());
			ccdl.countDown();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
