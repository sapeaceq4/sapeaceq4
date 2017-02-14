package org.om.aec.algo.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.om.aec.utils.AppUtils;

public class Cache<K,V> extends LinkedHashMap<K, V>
{
	private static final long serialVersionUID = 1L;
	private int capacity;

	public Cache(int capacity)
	{
		this(capacity, 0, 0);
	}
	
	public Cache(int capacity, long timeToLiveInMillis, long accessTimeExpiredInMillis)
	{
		if(capacity < 0)
			throw new IllegalArgumentException("Please provide the valid arguments");
		this.capacity = capacity;
		if(timeToLiveInMillis > 0)
			new TimeToLivePloicy(timeToLiveInMillis).apply();
		
		if(accessTimeExpiredInMillis > 0)
			new AccessTimeExpirePolicy(accessTimeExpiredInMillis).apply();
	}

	public synchronized V get(Object key)
	{
		@SuppressWarnings("unchecked")
		CacheItem cacheItem = (CacheItem)super.get(key);
		if(cacheItem == null)
			return null;
		cacheItem.updateAccessTime(System.currentTimeMillis());
		return cacheItem.getValue();
	}
	
	public synchronized V remove(Object key)
	{
		@SuppressWarnings("unchecked")
		CacheItem cacheItem = (CacheItem)super.remove(key);
		return cacheItem.getValue();
	}

	public synchronized List<V> values() 
	{
		List<V> values = new ArrayList<V>();
		for (V value : super.values()) 
		{
			@SuppressWarnings("unchecked")
			CacheItem cacheItem = (CacheItem)value;
			cacheItem.updateAccessTime(System.currentTimeMillis());
			values.add(cacheItem.getValue());
		}
		return values;
	}

	@Override
	protected synchronized boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest)
	{
		return size() > capacity;	
	}

	@SuppressWarnings("unchecked")
	public synchronized V put(K key, V value)
	{
		return super.put(key, (V)new CacheItem(value));
	}

	class CacheItem
	{
		private long creationTime;
		private long lastAccessTime;
		private V value;

		CacheItem(V value)
		{
			this.lastAccessTime = System.currentTimeMillis();
			this.creationTime = System.currentTimeMillis();
			this.value = value;
		}
		void updateAccessTime(long accessTime){
			this.lastAccessTime = accessTime;
		}
		long getLastAccessTime(){
			return lastAccessTime;
		}
		long getCreationTime() {
			return creationTime;
		}
		V getValue() {
			return value;
		}
		@Override
		public String toString() {
			return "CacheItem [creationTime=" + creationTime + ", accessTime="
					+ lastAccessTime + ", value=" + value + "]";
		}
	}

	abstract class CachePolicy implements Runnable
	{
		private static final int DEFAULT_POLICY_WAITINF_TIME = 500; 
		protected long expireInMills;
		private volatile boolean isPolicyStopRequested;
		private Thread thread;
		CachePolicy(long expireInMills)
		{
			this(expireInMills, DEFAULT_POLICY_WAITINF_TIME);
		}

		CachePolicy(long expireInMills, long policyWaitingTime)
		{
			this.expireInMills = expireInMills;
			thread = new Thread(this);
		}
		
		void apply()
		{
			thread.start();
		}

		void discard()
		{
			isPolicyStopRequested = true;
			thread.interrupt();
		}
		
		@Override
		public void run()
		{
			while(!isPolicyStopRequested)
			{
				synchronized (Cache.this) 
				{
					List<K> keysWillBeRemove = new ArrayList<K>();
					for (java.util.Map.Entry<K, V> entry : entrySet())
					{
						@SuppressWarnings("unchecked")
						CacheItem internalItem = (CacheItem)entry.getValue();
						if(test(internalItem))
						{
							keysWillBeRemove.add(entry.getKey());
						}
					}
					for(K key: keysWillBeRemove)
					{
						remove(key);
					}
					keysWillBeRemove.clear();
				}
				AppUtils.asleep(DEFAULT_POLICY_WAITINF_TIME);
			
			}
		}
	
		abstract boolean test(CacheItem cacheItem);
	}
	
	class AccessTimeExpirePolicy extends CachePolicy
	{
		AccessTimeExpirePolicy(long accessTimeExpireInMills)
		{
			super(accessTimeExpireInMills);
		}
		AccessTimeExpirePolicy(long accessTimeExpireInMills, long policyWaitingTime)
		{
			super(accessTimeExpireInMills, policyWaitingTime);
		}
		
		@Override
		boolean test(CacheItem cacheItem) 
		{
			long lastAccessTime = System.currentTimeMillis() - cacheItem.getLastAccessTime();
			return lastAccessTime >= expireInMills? true: false;
		}
	}
	
	class TimeToLivePloicy extends CachePolicy
	{
		TimeToLivePloicy(long timeToLiveTimeInMillis)
		{
			super(timeToLiveTimeInMillis);
		}

		TimeToLivePloicy(long timeToLiveTimeInMillis, long policyWaitingTime)
		{
			super(timeToLiveTimeInMillis, policyWaitingTime);
		}
		
		@Override
		boolean test(CacheItem cacheItem) 
		{
			long lastAccessTime = System.currentTimeMillis() - cacheItem.getCreationTime();
			return lastAccessTime >= expireInMills? true: false;
		}
	}

}
