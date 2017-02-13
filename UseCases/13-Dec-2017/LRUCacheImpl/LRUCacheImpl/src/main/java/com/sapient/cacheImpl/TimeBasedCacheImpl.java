package com.sapient.cacheImpl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sapient.cache.Cache;

/**
 * @author
 * @param <K,V>
 *            This class provides Time Based Cache eviction Strategy.
 */
public class TimeBasedCacheImpl<K, V> implements Cache<K, V> {

	private long expiryTime;
	private Map<K, CacheValueObject<V>> cacheMap;
	private boolean evictionNotification;
	private Object obj= new Object();

	public TimeBasedCacheImpl(long expiryTime) {
		this.expiryTime = expiryTime;
		this.cacheMap = new ConcurrentHashMap<K, CacheValueObject<V>>();
		this.evictionNotification = false;

		// Thread to check Expiry of Values in Cache
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000); // Checking cacheMap after 1sec.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					checkValueExpiry();

				}
			}

		}).start();
	}

	/**
	 * This method is invoked after every T time where T is the interval time
	 * This method checks the keys present in cache if they are eligible for
	 * eviction based on expiry time specified.
	 */
	private void checkValueExpiry() {
		Set<Entry<K, CacheValueObject<V>>> entrySet = cacheMap.entrySet();
		Iterator<Entry<K, CacheValueObject<V>>> iterator = entrySet.iterator();
		CacheValueObject<V> valueHolder = null;

		while (iterator.hasNext()) {
			Entry<K, CacheValueObject<V>> entryObj = iterator.next();
			valueHolder = entryObj.getValue();
			if (valueHolder != null && (System.currentTimeMillis() > (expiryTime + valueHolder.getAccessTimeStamp()))) {
				if (evictionNotification) {
					System.out.println("Eviction Notification----" + entryObj.getKey());
				}
				synchronized (obj) {
					cacheMap.remove(entryObj.getKey());
				}

			}
		}
	}

	@Override
	public void put(K key, V value) {
		synchronized (obj) {
			CacheValueObject<V> holder = new CacheValueObject<V>(value);
			cacheMap.put(key, holder);
		}
	}

	@Override
	public V get(K key) {
		synchronized (obj) {
			CacheValueObject<V> value = cacheMap.get(key);
			if (value == null) {
				return null;
			} else {
				value.accessTimeStamp = System.currentTimeMillis();
				return (V) value.getValue();
			}
		}
	}

	@Override
	public void getEvictionNotification(boolean enableNotif) {
		evictionNotification = enableNotif;
	}

	/**
	 * Class used to hold the value corresponding to a key in cache. It also
	 * holds the time stamp of the last accessed time for that key
	 * 
	 * @param <V>
	 */
	private class CacheValueObject<V> {
		private long accessTimeStamp;
		private V value;

		public CacheValueObject(V value) {
			this.accessTimeStamp = System.currentTimeMillis();
			this.value = value;
		}

		public V getValue() {
			return value;
		}

		public long getAccessTimeStamp() {
			return accessTimeStamp;
		}
	}

}
