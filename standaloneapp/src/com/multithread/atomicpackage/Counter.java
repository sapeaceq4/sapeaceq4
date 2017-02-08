package com.multithread.atomicpackage;

/**
 * 
 * @author ssh200 Class to store the hits on a web-page
 */
public class Counter {

	private int i = 0;

	public Counter() {

	}

	synchronized void increment() {
		i++;
	}

	int getCount() {
		return i;
	}
}
