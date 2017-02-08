package com.multithread;

public class GreetingRunnable implements Runnable{

	private static final int REPETITION = 10;
	private static final int DELAY = 2000;
	
	private String greeting;
	private boolean b;

	public GreetingRunnable(boolean b,String greeting) {
		this.greeting = greeting;
		this.b=b;
	}
	
	@Override
	public void run() {
		System.out.println(GreetingRunnable.class+" calling run method..");
		for(int i=0;i<REPETITION;i++){
			System.out.println(getTab() + Thread.currentThread().getName() +":" +greeting + " "+i);
		}	
	}
	
	private String getTab(){
		String tab = "\t\t";
		if(b){
			tab = tab+"t\t\t";
		}
		return tab;
	}
}
