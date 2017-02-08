package com.designpattern.CreationalDesignPattern.singleton;

public class GetTiles implements Runnable {

	@Override
	public void run() {
		
		Singleton newInstance = Singleton.getInstance();
		
		System.out.println("Instance ID "+System.identityHashCode(newInstance));
		
		System.out.println("letters "+newInstance.getScrabbleLettes());
		
		System.out.println("players "+newInstance.getTiles(5));
		
		System.out.println("letters again "+newInstance.getScrabbleLettes());
	}
}
