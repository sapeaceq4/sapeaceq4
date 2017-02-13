package com.sapient.ace.usecases;

import java.util.List;

class Producer implements Runnable {

	private List<Integer> sharedList;
	static int count = 0;
	public Producer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while (true) {
			synchronized(sharedList) {
				try {
					if (sharedList.size() < 5) {
						Integer toPut = ++count;
						System.out.println(Thread.currentThread().getName() + ":" + toPut);
						sharedList.add(toPut);
						sharedList.notifyAll();
					} else {
						sharedList.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
