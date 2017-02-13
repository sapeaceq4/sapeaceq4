package com.cache.dao;

import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class CountryCacheContainer implements Runnable{

	private static CountryCacheContainer cacheContainer = new CountryCacheContainer();
	private static long TIME_TO_LIVE_THRSHOLD = 1000*60;  //60 Seconds
	private static long TIME_TO_STALE_THRSHOLD = 1000*30;  //30 Seconds
	private CountryCache longhestLivedItem = null;
	private static ConcurrentHashMap<CountryCache,CountryCache> countryCaches = new ConcurrentHashMap<CountryCache, CountryCache>();
	
	public static CountryCacheContainer getInstance(){
		return cacheContainer;
	}
	
	public void addItem(Country country){
		if(!cacheContainer.countryCaches.contains(country)){
			if(countryCaches.size() > 5){
				removeLongehestLivedItem();
			}
			Long currentTime = Calendar.getInstance().getTimeInMillis();
			CountryCache countryCache = new CountryCache(currentTime, currentTime, country);
			cacheContainer.countryCaches.put(countryCache, countryCache);
		}
	}

	@Override
	public void run() {
		while(true){
			KeySetView<CountryCache, CountryCache> keySetView = cacheContainer.countryCaches.keySet();
			Iterator<CountryCache> iterator = keySetView.iterator();
			while(iterator.hasNext()){
				Long currentTime = Calendar.getInstance().getTimeInMillis();
				CountryCache countryCache = iterator.next();
				if(currentTime - countryCache.getLiveThreshold() > TIME_TO_LIVE_THRSHOLD){
					iterator.remove();
				}else{
					if(currentTime - countryCache.getStaleThreshold() > TIME_TO_STALE_THRSHOLD){
						iterator.remove();
					}
				}
		
			}
		}
	}
	
	
	public void removeLongehestLivedItem(){
		KeySetView<CountryCache, CountryCache> keySetView = cacheContainer.countryCaches.keySet();
		Iterator<CountryCache> iterator = keySetView.iterator();
		while(iterator.hasNext()){
			Long currentTime = Calendar.getInstance().getTimeInMillis();
			CountryCache countryCache = iterator.next();
			if(longhestLivedItem == null){
				longhestLivedItem = countryCache;
			}else{
				if(countryCache.getLiveThreshold() > longhestLivedItem.getLiveThreshold()){
					longhestLivedItem = countryCache;
				}
			}
		}
		if(longhestLivedItem != null){
			System.out.println("Remvoing longhest lived item from cache");
			cacheContainer.countryCaches.remove(longhestLivedItem);
			longhestLivedItem = null;
		}
	}
	
	
}
