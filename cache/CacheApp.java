package com.prac.cache;

public class CacheApp
{
	public static void main(String[] args) 
	{
		Caching<String, Integer> caching = new Caching<String, Integer>(2, 10000);
		caching.put("One", 1);
		sleepTime(100);
		caching.put("Two", 2);
		sleepTime(500);
		caching.put("Three", 3);
		sleepTime(1000);
		caching.put("Four", 4);
		while(true)
		{
			sleepTime(100);
			
			synchronized (caching) {
				
				System.out.println(caching.values());
			}
			
		}
		
	}
	public static void sleepTime(long millis)
	{
		try 
		{
			Thread.sleep(millis);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}