
package com.sapient.cache;

public interface Cache<K, V> {

	/**
	 * This method is used to put a key value pair into the Cache
	 * 
	 * @param key
	 * @param value
	 */
	public abstract void put(K key, V value);

	/**
	 * This method is used to get the value from Cache based on key as input
	 * param
	 * 
	 * @param key
	 * @return Value V for that key from Cache if present, Else null
	 */
	public abstract V get(K key);

	/**
	 * This method is used to send notification to user in case a key is evicted
	 * from the cache.
	 * 
	 * @param enableNotif
	 */
	public abstract void getEvictionNotification(boolean enableNotif);

}
