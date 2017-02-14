package org.om.aec.concurrency.exchanger;

public interface ILatch 
{
	void countDown();
	void await()throws InterruptedException;
}
