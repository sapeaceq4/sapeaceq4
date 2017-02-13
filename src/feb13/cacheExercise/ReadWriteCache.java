package feb13.cacheExercise;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadWriteCache implements ICache {
	
	private static final ConcurrentHashMap<Object,Cacheable> cacheHashMap = new ConcurrentHashMap<Object,Cacheable>();
	private long cacheCleanTimer ;
	private static AtomicInteger currentCacheSize = new AtomicInteger(0);
	private int cacheMaxSize;

	
	public ReadWriteCache()
	{
		this.cacheMaxSize = CacheConstants.MAX_CACHE_SIZE.getValue();
		this.cacheCleanTimer =TimeUnit.MINUTES.toSeconds(CacheConstants.DEFAULT_OBJECT_EXPIRETIME.getValue());
		startCacheCleanerService(cacheCleanTimer);
	}

	public ReadWriteCache(int cacheSize,int stalePeriod)
	{
		this.cacheMaxSize = cacheSize;
		this.cacheCleanTimer = stalePeriod;
		startCacheCleanerService(cacheCleanTimer);
	}
	
	
	@Override
	public synchronized void putCache(Cacheable object) {

		if(currentCacheSize.get() >= getCacheMaxSize()){
			removeOutdadedObjectFromCache();
		}
		cacheHashMap.put(object.getIdentifier(), object);
		currentCacheSize.incrementAndGet();
	}

	@Override
	public Cacheable getCache(Object identifier) {
		return cacheHashMap.get(identifier);
	}
	
	public int getCacheMaxSize() {
		return cacheMaxSize;
	}
	
	private static void startCacheCleanerService(long cacheCleanTimer){
		CacheManager cacheManager = new CacheManager(cacheHashMap, cacheCleanTimer);
		Thread  cacheManagerService = new Thread(cacheManager);
		cacheManagerService.start();
	}
	
	private Object removeOutdadedObjectFromCache(){
		
		Cacheable objectToRemoveValue=null;
		Object objToRemoveKey=null;
		
		for(Object key :cacheHashMap.keySet()){
			Cacheable value = (Cacheable)cacheHashMap.get(key);
			if(objectToRemoveValue == null){
				objectToRemoveValue = (CachedObject) value;
				objToRemoveKey = key;
			}
			else{
				if(objectToRemoveValue.getDateOfexpiration().after(value.getDateOfexpiration())){
					objectToRemoveValue=value;
					objToRemoveKey = key;
				}
			}
		}
		if(currentCacheSize.get() >= getCacheMaxSize()){
			synchronized(cacheHashMap){
				cacheHashMap.remove(objToRemoveKey);
			}
			System.out.println("Removed last used object from cache :"+objectToRemoveValue.getIdentifier());
		}
		return objToRemoveKey;
	}

}
