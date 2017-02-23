package ThreadPractice;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentCounter {
	
	private volatile int  count = 0;
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public void increment()
	{
		rwl.writeLock().lock();
		count++;
		rwl.writeLock().unlock();
	}

	public void decrement(){
		rwl.writeLock().lock();
		count--;
		rwl.writeLock().unlock();
	}
	
	public int getCount(){
		return count;
	}
}

