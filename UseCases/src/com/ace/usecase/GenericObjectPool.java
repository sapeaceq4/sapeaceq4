package com.ace.usecase;

import java.util.HashMap;

/**
 * 
 * @author asi233
 *
 */
public class GenericObjectPool<T> {

	private final int DEFAULT_POOL_SIZE = 10;
	private Object[] genericPoll;
	private Class<T> theClass = null;
	
	private static HashMap available;
	private static HashMap inUse;

	/**
	 * Defalut size will be DEFAULT_POOL_SIZE = 10
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public GenericObjectPool(Class<T> theClass) throws InstantiationException, IllegalAccessException {
		new GenericObjectPool<T>(DEFAULT_POOL_SIZE, theClass);
	}

	/**
	 * The fixed poll size
	 * 
	 * @param pollSize
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public GenericObjectPool(int pollSize, Class<T> theClass2) throws InstantiationException, IllegalAccessException {
		genericPoll = new Object[pollSize];
		intializePool();
		
	}
	
//	public T getObjectFromPool(){
//		
//	}

	private void intializePool() throws InstantiationException,
			IllegalAccessException {
		for (int i = 0; i < genericPoll.length; i++) {
			genericPoll[i] = (T) this.theClass.newInstance();
		}
	}
}
