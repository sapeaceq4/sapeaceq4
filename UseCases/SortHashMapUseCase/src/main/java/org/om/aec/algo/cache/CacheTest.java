package org.om.aec.algo.cache;

import org.om.aec.utils.CommonTools;

public class CacheTest
{
	public static void main(String[] args) 
	{
		Cache<String, Integer> cache = new Cache<String, Integer>(4, 2000, 2000);
		cache.put("A", 1);
		CommonTools.asleep(100);
		cache.put("B", 2);
		CommonTools.asleep(500);
		cache.put("C", 3);
		CommonTools.asleep(1000);
		cache.put("D", 4);
		while(true)
		{
			CommonTools.asleep(100);
			synchronized (cache)
			{
				System.out.println("Access by client:"+cache.get("D") +" ,size="+ cache.size());
			}
		}
	}
}
