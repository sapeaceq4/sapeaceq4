package org.om.aec.algo.cache;

import org.om.aec.utils.AppUtils;

public class CacheTest
{
	public static void main(String[] args) 
	{
		Cache<String, Integer> cache = new Cache<String, Integer>(2, 10000);
		cache.put("A", 1);
		AppUtils.asleep(100);
		cache.put("B", 2);
		AppUtils.asleep(500);
		cache.put("C", 3);
		AppUtils.asleep(1000);
		cache.put("D", 4);
		while(true)
		{
			AppUtils.asleep(100);
			
			synchronized (cache) {
				
				System.out.println(cache.values());
			}
			
		}
		
	}
}
