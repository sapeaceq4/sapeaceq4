package com.sapient.ace.cache;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	
	private static Cache INSTANCE;
	
	public Cache getInstance(){
		
		if(INSTANCE == null){
			INSTANCE = new Cache();
		}
		
		return INSTANCE;
	}

	private static int DEFALUT_TIME_TO_LIVE = 2;
	private static int DEFALUT_STALE_PERIOD = 2;
	private static int DEFAULT_NUMBER_OF_ENTRIES = 30;
	
	private static boolean run = true;

	private int timeToLive;
	private int stalePeriod;
	private int numberOfEntires;

	public Cache(int timeToLive, int stalePeriod, int numberOfEntires) {
		this.timeToLive = timeToLive;
		this.stalePeriod = stalePeriod;
		this.numberOfEntires = numberOfEntires;
		StartCache();
	}

	private void StartCache() {
		new Thread() {
			@Override
			public void run() {
				while(run){
				for(String key :cacheMap.keySet()){
					CacheUnit cache = keyQueue.get(key);
					if(cache.getCreatedTime().compareTo(new Date()) > timeToLive){
						cacheMap.remove(key);
						keyQueue.remove(key);
					}
				}
				
				for(String key :cacheMap.keySet()){
					CacheUnit cache = keyQueue.get(key);
					if(cache.getUpdatedTime().compareTo(new Date()) > stalePeriod){
						cacheMap.remove(key);
						keyQueue.remove(key);
					}
				}
			}
				
			}
		}.start();
	}

	private Cache() {
		this.timeToLive = DEFALUT_TIME_TO_LIVE;
		this.stalePeriod = DEFALUT_STALE_PERIOD;
		this.numberOfEntires = DEFAULT_NUMBER_OF_ENTRIES;
	}
	
	public void stop(){
		run = false;
	}

	private Map<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();
	private Map<String, CacheUnit> keyQueue = new ConcurrentHashMap<String, CacheUnit>();
	
	public boolean remove(String key){
		cacheMap.remove(key);
		keyQueue.remove(key);
		return true;
		
	}
	
	public Object get(String key){
		if(!cacheMap.containsKey(key)){
			return null;
		}
		CacheUnit cacheUnit = keyQueue.get(key);
		cacheUnit.setUpdatedTime(new Date());
		return cacheMap.get(key);
	}

	public boolean add(String key, Object obj) throws Exception {
		if (key == null || obj == null) {
			throw new Exception("Key or Value should not be null");
		}

		if (cacheMap.size() == numberOfEntires) {
			throw new Exception("Reached max number of element in map");
		}

		cacheMap.put(key, obj);

		if (keyQueue.containsKey(key)) {
			CacheUnit cacheUnit = keyQueue.get(key);
			cacheUnit.setCreatedTime(new Date());
			cacheUnit.setUpdatedTime(new Date());
		} else {
			CacheUnit cacheUnit = new CacheUnit();
			cacheUnit.setKey(key);
			cacheUnit.setCreatedTime(new Date());
			cacheUnit.setUpdatedTime(new Date());
			keyQueue.put(key, cacheUnit);
		}

		return true;

	}

	class CacheUnit {
		private String key;
		private Date createdTime;
		private Date updatedTime;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Date getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}

		public Date getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(Date updatedTime) {
			this.updatedTime = updatedTime;
		}

	}

}
