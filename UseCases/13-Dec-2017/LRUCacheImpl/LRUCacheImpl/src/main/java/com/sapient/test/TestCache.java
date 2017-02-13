package com.sapient.test;

import java.util.Calendar;

import com.sapient.cache.Cache;
import com.sapient.cacheImpl.TimeBasedCacheImpl;

public class TestCache {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);

		System.out.println(cal.getTime());

		long expiryTime = 5 * 1000;
		Cache cache = new TimeBasedCacheImpl<String, String>(expiryTime);
//		cache.getEvictionNotification(false);
		System.out.println(System.currentTimeMillis());
		cache.getEvictionNotification(true);
		cache.put("Test1", "Test1");
		cache.put("Test2", "Test2");
		cache.put("Test3", "Test3");
		cache.put("Test4", "Test4");

		String val = (String) cache.get("Test1");
		System.out.println(val);

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String val1 = (String) cache.get("Test1");
		System.out.println("Getting 2 " + val1);
		
		cache.put("Test3", "Test3");
		cache.put("Test4", "Test4");
		cache.put("Test2", "Test2");
		String val2 = (String) cache.get("Test2");
		System.out.println("Getting 3 " + val2);
	}

}
