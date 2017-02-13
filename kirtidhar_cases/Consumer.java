package com.sapient.ace.usecases;

import java.util.List;

class Consumer implements Runnable {

	private List<Integer> sharedList;

	public Consumer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while (true) {
			synchronized(sharedList) {
				try {
					if (sharedList.size() > 1) {
						System.out.println(Thread.currentThread().getName() + ":" + sharedList.remove(0));
						Thread.sleep(1000);
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