package com.multithread.printoddevennumber;

public class EvenNumberThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<12;i++){
				if(i%2==1){
					Thread.sleep(1000);
					System.out.println("Even number "+i);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
