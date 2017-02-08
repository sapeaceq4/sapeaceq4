package com.multithread.semaphore;

import java.util.concurrent.Semaphore;

public class Pool {

	private static final int MAX_AVAILABLE = 100;
	private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

	protected Object[] items = new Object[10];
	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Object getItem() throws InterruptedException{
		semaphore.acquire();
		return getNextAvailableItem();
	}
	
	public void putItem(Object x){
		if(markAsUnused(x)){
			semaphore.release();
		}
	}
	
	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}
	
	protected synchronized boolean markAsUnused(Object objItem){
		for(int i=0;i<MAX_AVAILABLE;i++){
			if(objItem==items[i]){
				if(used[i]){
					used[i] = false;
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}
}
