package org.om.aec.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class CHM 
{
	public static void main(String[] args) throws InterruptedException 
	{

		int initialCapacity = 17;
        float loadFactor= .75f;
        int concurrencyLevel = 16;
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<String, Integer>
		
		(initialCapacity,loadFactor, concurrencyLevel);
		chm.put("A", 1);
		chm.put("B", 2);
		chm.put("C", 3);
		chm.put("D", 4);
		System.out.println(chm.keySet().size());
		KeySetView<String, Integer> keySet = chm.keySet();
		for (String key : keySet)
		{
			chm.remove("B");
			Thread.sleep(1000);
			System.out.println(key+"------------------"+chm.get(key));
			System.out.println(keySet.size());
		}
	}
}
