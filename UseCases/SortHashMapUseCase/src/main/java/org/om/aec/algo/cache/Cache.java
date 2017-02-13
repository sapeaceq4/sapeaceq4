package org.om.aec.algo.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.om.aec.utils.AppUtils;

public class Cache<K,V> extends LinkedHashMap<K, V>
{
	private static final long serialVersionUID = 1L;
	private int capacity;
	
	public Cache(int capacity, long timeToLiveInMillis)
	{
		if(capacity < 0 && timeToLiveInMillis < 0)
			throw new IllegalArgumentException("Please provide valid argument");
		this.capacity = capacity;
		
		new TimeToLivePloicy(timeToLiveInMillis).apply();
	}
	
	 public synchronized V remove(Object key)
	 {
		 return super.remove(key);
	 }
	
	public synchronized Collection<V> values() 
	{
		return super.values();
	}
	
	@Override
	protected synchronized boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest)
	{
		return size() > capacity;	
	}
	
	public synchronized V put(K key, V value)
	{
		return super.put(key, (V)new InternalItem(key, value));
	}
	
	class InternalItem
	{
		private long creationTime;
		private V value;
		private K key;
		InternalItem(K key, V value)
		{
			this.key = key;
			creationTime = System.currentTimeMillis();
			this.value = value;
		}
		public K getKey() 
		{
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
	
	class TimeToLivePloicy implements Runnable
	{
		private static final int DEFAULT_WAITINF_TIME = 500;
		private long retainTime;
		public Thread thread;
		
		TimeToLivePloicy(long timeToLiveTimeInMillis)
		{
			this(timeToLiveTimeInMillis, DEFAULT_WAITINF_TIME);
		}
		
		TimeToLivePloicy(long timeToLiveTimeInMillis, long policyWaitingTime)
		{
			this.retainTime = timeToLiveTimeInMillis;
			thread = new Thread(this);
		}
		
		public void apply()
		{
			thread.start();
		}
		
		public void stop()
		{
			thread.interrupt();
		}
		
		@Override
		public void run() 
		{
			while(true)
			{
				synchronized (TimeToLivePloicy.this) 
				{
					List<K> keysWillBeRemove = new ArrayList<K>();
					
					for (V v : values()) 
					{
						InternalItem internalItem = (InternalItem)v;
						long spendTime = System.currentTimeMillis() - internalItem.getCreationTime();
						if(spendTime >= retainTime)
						{
							keysWillBeRemove.add(internalItem.getKey());
						}
					}
					for(K key: keysWillBeRemove)
					{
						remove(key);
					}
					
				}
				
				AppUtils.asleep(DEFAULT_WAITINF_TIME);
			}
		}
	}
}
