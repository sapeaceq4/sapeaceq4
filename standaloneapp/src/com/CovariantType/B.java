package com.CovariantType;

public class B extends A {


	@Override
	B get() {
		return this;
	}
	
	void message(){
		System.out.println("this is test message");
	}
	
	public static void main(String args[]){
		new B().get().message();;
	}
}
