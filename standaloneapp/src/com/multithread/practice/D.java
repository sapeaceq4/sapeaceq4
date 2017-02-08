package com.multithread.practice;

public class D {

	int i;
	int j;

	public D(int i, int j) {
		this.i = i;
		this.j = j;

	}
	
	public void printName(){
		System.out.println("Print name");
	}
}

class Test{
	
	public static void main(String[] args) {
		//Compilation error
		//D d = new D();
		//below is correct 
		
		D d = new D(1, 2);
		d.printName();
	}
}
