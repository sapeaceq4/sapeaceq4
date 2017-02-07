package com.sapient.ace.Walkman;

public class WalkmanTest {

	private static int serialID;
	
	public static int getWalkmanID(){
		serialID=serialID+1;
		return serialID;
	}
	
	public static void main(String[] args) {
	
		System.out.println(WalkmanTest.getWalkmanID());
		System.out.println(WalkmanTest.getWalkmanID());
		
		
		
	}


}
