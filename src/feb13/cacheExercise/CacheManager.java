package feb13.cacheExercise;

import java.util.concurrent.ConcurrentHashMap;

public class CacheManager implements Runnable {
	private  ConcurrentHashMap<Object,Cacheable> cacheHashMap =null;
	private long cacheCleanTimer;
	private boolean runCacheManager = true;

	public CacheManager(ConcurrentHashMap<Object,Cacheable> cacheHashMap, long cacheCleanTimer){
		this.cacheHashMap = cacheHashMap;
		this.cacheCleanTimer = cacheCleanTimer;
	}

	@Override
	public void run() {
		while(runCacheManager){
			
			for(Object key :cacheHashMap.keySet()){
				Cacheable value = (Cacheable)cacheHashMap.get(key);
				if(value.isExpired()){
					synchronized(cacheHashMap){  
						cacheHashMap.remove(key);
					}
				}
			}
			try {
				Thread.sleep(this.cacheCleanTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void setRunCacheManager(boolean runCacheManager) {
		this.runCacheManager = runCacheManager;
	}

}
