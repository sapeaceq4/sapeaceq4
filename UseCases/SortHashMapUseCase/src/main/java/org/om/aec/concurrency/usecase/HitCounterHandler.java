package org.om.aec.concurrency.usecase;

import java.util.concurrent.atomic.AtomicInteger;

public class HitCounterHandler
{
	private AtomicInteger hitCounter = new AtomicInteger();

	public int hit()
	{
		return hitCounter.incrementAndGet();
	}
}
