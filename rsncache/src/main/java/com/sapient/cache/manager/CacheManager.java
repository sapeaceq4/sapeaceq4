package com.sapient.cache.manager;

import com.sapient.cache.Cache;
import com.sapient.cache.CacheExpiryWatcher;
import com.sapient.cache.evictors.EvictionStrategy;
import com.sapient.cache.evictors.SizeEvictionStrategy;
import com.sapient.cache.evictors.TimedEvictionStrategy;
import com.sapient.cache.exception.CacheException;
import com.sapient.cache.notification.CacheNotificationListener;
import com.sapient.cache.utils.CacheConstants;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh
 */
public class CacheManager {
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static <K, V> Cache getCache(int capacity, String type, CacheNotificationListener observer) {
        Cache<K, V> cache = new Cache<K, V>(capacity);
        EvictionStrategy strategy = new TimedEvictionStrategy();
        if (type.equalsIgnoreCase(CacheConstants.TIMED_CACHE_EVICTION)) {
            strategy = new TimedEvictionStrategy();
        } else if (type.equalsIgnoreCase(CacheConstants.SIZE_CACHE_EVICTION)) {
            strategy = new SizeEvictionStrategy();
        }
        if (observer == null) {
            throw new CacheException("Not able to add CacheNotificationListener to cache. Value is : " + observer);
        }
        cache.addObserver(observer);
        scheduler.scheduleAtFixedRate(new CacheExpiryWatcher(strategy, cache), 0, CacheConstants.EXPIRY_WATCHER_WAIT_TIME, TimeUnit.SECONDS);
        return cache;
    }

    public static void shutdownEvictor() {
        scheduler.shutdown();
    }
}

