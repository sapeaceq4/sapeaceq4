package org.om.aec.concurrency.exchanger.future;

public interface IFuture<V> extends Runnable
{
	V get();
	boolean isDone();
	int getProgressPercentage();
}
