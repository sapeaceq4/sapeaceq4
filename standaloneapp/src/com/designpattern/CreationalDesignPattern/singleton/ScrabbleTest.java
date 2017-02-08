package com.designpattern.CreationalDesignPattern.singleton;

public class ScrabbleTest {

	public static void main(String[] args){
		Singleton newInstance = Singleton.getInstance();
		
		System.out.println("Intance 1 ID :" +System.identityHashCode(newInstance));
		
		System.out.println("Letters 1 "+newInstance.getScrabbleLettes());
		
		System.out.println("Players 1 "+newInstance.getTiles(7));
		
		System.out.println("new latters "+newInstance.getScrabbleLettes());
		
		//Second Instance of the singleton class
		
		Singleton instanceTwo = Singleton.getInstance();

		System.out.println("Instance 2 ID: "+System.identityHashCode(instanceTwo));
		
		System.out.println("Letters 2 "+instanceTwo.getScrabbleLettes());
		
		System.out.println("Players 2 "+instanceTwo.getTiles(7));
		
		System.out.println("new Letters 2 "+instanceTwo.getScrabbleLettes());
 	}
}
