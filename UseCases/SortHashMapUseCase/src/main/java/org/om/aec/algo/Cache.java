package org.om.aec.algo;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K,V> extends LinkedHashMap<K, V>
{
	private static final long serialVersionUID = 1L;
	private int maxEntryAllowd;
	private long timeToLive;

	public Cache(int maxEntryAllowd, long timeToLiveInMillis)
	{
		super();
		this.maxEntryAllowd = maxEntryAllowd;
		this.timeToLive = timeToLiveInMillis;
	}

	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) 
	{
		return size() > maxEntryAllowd;
	}
	
	@SuppressWarnings("unchecked")
	public V put(K key, V value)
	{
        return super.put(key, (V)new TimeData(value));
    }

	class TimeToLivePolicy implements Runnable
	{
		private long millis;
		private Thread thread = null;
		public TimeToLivePolicy(long millis)
		{
			this.millis = millis;
			thread = new Thread(this);
		}
		
		public void apply()
		{
			thread.start();
		}

		@Override
		public void run() 
		{
			for (V v : values())
			{
				TimeData data = (TimeData)v;
				
				//TODO: Compare and remove
			}
		}
		
	}
	
	class TimeData
	{
		public Date date;
		public V value;
		
		public TimeData(V value)
		{
			this.date = new Date(System.currentTimeMillis());
			this.value = value;
		}

		@Override
		public String toString() {
			return "TimeData [date=" + date + ", value=" + value + "]";
		}
	}
	
	
	public static void main(String[] args)
	{
		Cache<String,Integer> lists = new Cache<String,Integer>(1, 10);
		lists.put("a", 1);
		lists.put("b", 2);
		System.out.println(lists.get("a"));
		lists.put("d", 3);
		System.out.println(lists);
	}
}
