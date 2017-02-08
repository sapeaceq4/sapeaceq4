package com.multithread;

public class ThreadMain {

	public static void main(String[] args) {
		Thread t = new Thread(new MyrunnableThread());
		t.start();
	}
}
