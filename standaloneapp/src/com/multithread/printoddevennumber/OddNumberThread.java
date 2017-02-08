package com.multithread.printoddevennumber;

public class OddNumberThread implements Runnable{

	@Override
	public void run(){
		try {
			for(int i=0;i<12;i++){
				if(i%2==0){
					Thread.sleep(1000);
					System.out.println("Odd number "+i);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
