package com.multithread.practice;

public class C {

	public static void main(String[] args) {
		new Thread(new B(),"T1").start();
	}
}
