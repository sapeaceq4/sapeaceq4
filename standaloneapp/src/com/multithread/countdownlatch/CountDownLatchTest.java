package com.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String args[]){
		CountDownLatch latch = new CountDownLatch(3);
		
		Waiter wait = new Waiter(latch);
		Dcrementar dcrementar =new Dcrementar(latch);
		
		new Thread(wait).start();
		new Thread(dcrementar).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
