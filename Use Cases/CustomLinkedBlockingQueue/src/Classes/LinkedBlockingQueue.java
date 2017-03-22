package Classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueue {

	private final Queue linkList = new LinkedList<Integer>();

	private final Lock takeLock = new ReentrantLock();

	private final Condition listEmpty = takeLock.newCondition();

	private final Lock putLock = new ReentrantLock();

	private final Condition listFull = putLock.newCondition();

	private final int maxCap;

	public LinkedBlockingQueue(int size) {
		maxCap = size;
	}

	private void signalNotEmpty() {
		takeLock.lock();
		try {
			listEmpty.signal();
		} finally {
			takeLock.unlock();
		}
	}

	private void signalNotFull() {
		putLock.lock();
		try {
			listFull.signal();
		} finally {
			putLock.unlock();
		}
	}

	public void put(Integer e) throws InterruptedException {
		if (e == null)
			throw new NullPointerException();

		putLock.lockInterruptibly();
		try {
			while (linkList.size() >= maxCap) {
				System.out.println("list full ");
				System.out.println(linkList);
				listFull.await();
			}
			linkList.add(e);
		} finally {
			putLock.unlock();
			signalNotEmpty();
		}
	}

	public Integer take() throws InterruptedException {
		takeLock.lockInterruptibly();
		try {
			while (linkList.size() < 1) {
				System.out.println("list empty ");
				System.out.println(linkList);
				listEmpty.await();
			}
			return (Integer) linkList.remove();
		} finally {
			takeLock.unlock();
			signalNotFull();
		}
	}
}
