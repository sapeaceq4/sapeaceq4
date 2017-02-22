package ThreadPractice;

import java.util.concurrent.CountDownLatch;

public class TestCustomCDL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomCountDownLatch ccdl = new CustomCountDownLatch(3);
		Thread t1 = new Thread(new MyRunnable(ccdl),"Thread1");	
		Thread t2 = new Thread(new MyRunnable(ccdl),"Thread2");
		Thread t3 = new Thread(new MyRunnable(ccdl),"Thread3");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			ccdl.await();
			System.out.println("i can run now");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
