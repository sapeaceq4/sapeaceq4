package com.prac.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public class Caching<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public Caching(int capacity, long ttlInMillis) {
		if (capacity < 0 && ttlInMillis < 0)
			throw new IllegalArgumentException("Please check the arguments");
		this.capacity = capacity;

		new TTLPolicy(ttlInMillis).apply();
	}

	public synchronized V remove(Object key) {
		return super.remove(key);
	}

	public synchronized Collection<V> values() {
		return super.values();
	}

	@Override
	protected synchronized boolean removeEldestEntry(
			java.util.Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

	public synchronized V put(K key, V value) {
		return super.put(key, (V) new Item(key, value));
	}

	class Item {
		private long creationTime;
		private V value;
		private K key;

		Item(K key, V value) {
			this.key = key;
			creationTime = System.currentTimeMillis();
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public long getCreationTime() {
			return creationTime;
		}

		public V getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "InternalItem [creationTime=" + creationTime + ", value="
					+ value + ", key=" + key + "]";
		}

	}

	class TTLPolicy implements Runnable {
		private static final int DEFAULT_WAITINF_TIME = 500;
		private long retainTime;
		public Thread thread;

		TTLPolicy(long timeToLiveTimeInMillis) {
			this(timeToLiveTimeInMillis, DEFAULT_WAITINF_TIME);
		}

		TTLPolicy(long timeToLiveTimeInMillis, long policyWaitingTime) {
			this.retainTime = timeToLiveTimeInMillis;
			thread = new Thread(this);
		}

		public void apply() {
			thread.start();
		}

		public void stop() {
			thread.interrupt();
		}

		@Override
		public void run() {
			while (true) {
				synchronized (TTLPolicy.this) {
					List<K> keysWillBeRemove = new ArrayList<K>();

					for (V v : values()) {
						Item internalItem = (Item) v;
						long spendTime = System.currentTimeMillis()
								- internalItem.getCreationTime();
						if (spendTime >= retainTime) {
							keysWillBeRemove.add(internalItem.getKey());
						}
					}
					for (K key : keysWillBeRemove) {
						remove(key);
					}

				}

				sleepTime(DEFAULT_WAITINF_TIME);
			}
		}

	}

	public static void sleepTime(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}