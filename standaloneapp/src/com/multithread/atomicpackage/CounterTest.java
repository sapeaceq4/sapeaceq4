package com.multithread.atomicpackage;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTest {

	public static void main(String[] args) {
		
	}
	/**Traditional way*/
	public static void counterTest(){
		Counter counter = new Counter();
		for(int index=0;index<1000;index++){
			counter.increment();
		}
	}
	/**Using AtomicInteger*/
	
	public static void counterTestUsingAtomicInteger(){
		AtomicInteger counter = new AtomicInteger(0);
		for(int index=0;index<1000;index++){
			counter.incrementAndGet();
		}
	}
}
