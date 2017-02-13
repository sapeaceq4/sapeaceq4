package com.main.java.sapient.caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CacheExample {

	private long timetoLive;

	private HashMap<String, CachedObject> cacheMap;

	public CacheExample(long timeToLive, final long timeInterval, int max) {
		this.timetoLive = timeToLive * 2000;

		cacheMap = new HashMap<String, CachedObject>(max);

		if (timeToLive > 0 && timeInterval > 0) {

			Thread t = new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(timeInterval * 1000);
						} catch (InterruptedException ex) {
						}

					}
				}
			});

			t.setDaemon(true);
			t.start();
		}
	}

	protected class CachedObject {
		public long lastAccess = System.currentTimeMillis();
		public String value;

		protected CachedObject(String value) {
			this.value = value;
		}
	}
	
	// PUT method
    public void put(String key, CachedObject value) {
        synchronized (cacheMap) {
            cacheMap.put(key, value);
        }
    }
    
    public String get(String key) {
        synchronized (cacheMap) {
        	CachedObject c =  cacheMap.get(key);
            
            if (c == null)
                return null;
            else {
                c.lastAccess = System.currentTimeMillis();
                return (String) c.value;
            }
        }
    }
    
    public void remove(String key) {
        synchronized (cacheMap) {
            cacheMap.remove(key);
        }
    }
    
    public int size() {
        synchronized (cacheMap) {
            return cacheMap.size();
        }
    }
    
    public void cleanup() {
        
        long now = System.currentTimeMillis();
        ArrayList<String> deleteKey = null;
        
        synchronized (cacheMap) {
            Iterator<?> itr = cacheMap.entrySet().iterator();
            
            deleteKey = new ArrayList<String>((cacheMap.size() / 2) + 1);
            CachedObject c = null;
            
            while (itr.hasNext()) {
                String key = (String) itr.next();
                c = (CachedObject) ((Entry<?, ?>) itr).getValue();
                if (c != null && (now > (timetoLive + c.lastAccess))) {
                    deleteKey.add(key);
                }
            }
        }
        
        for (String key : deleteKey) {
            synchronized (cacheMap) {
                cacheMap.remove(key);
            }
            
            Thread.yield();
        }
    }
    
    public static void main(String[] args) {
    	new CacheExample(100, 5, 400);
	}
}