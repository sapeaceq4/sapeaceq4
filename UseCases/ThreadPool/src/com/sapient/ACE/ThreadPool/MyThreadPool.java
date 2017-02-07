package com.sapient.ACE.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreadPool {
	private BlockingQueue<Runnable> tasks = null;
	private List<MyThread> threads = new ArrayList<MyThread>();
	boolean stop = false;

	public MyThreadPool(int size) {
		tasks = new ArrayBlockingQueue<Runnable>(size);
		for (int index = 0; index < size; index++) {
			threads.add(new MyThread(tasks));
		}
		for (MyThread th : threads) {
			th.start();
		}

	}

	public synchronized void execute(Runnable newTask) {
		if (!stop)
			tasks.offer(newTask);
	}

	public synchronized void shutdown() {
		stop = true;
		for (MyThread thread : threads) {
			thread.doStop();
		}
	}

}
