package org.om.aec.concurrency.exchanger;

public interface IBarrier
{
	void await()throws InterruptedException;
	void reset();
}
