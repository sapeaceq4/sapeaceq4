package com.sapient.cache;

import com.sapient.cache.utils.CacheConstants;

import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by rsi164 on 3/27/2017.
 */
public class CacheManager {
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static <K, V> Cache getCache(int capacity, String type, Observer observer) {
        Cache<K, V> cache = new Cache<K, V>(capacity);
        EvictionStrategy strategy = new TimedEvictionStrategy();
        if (type.equalsIgnoreCase(CacheConstants.TIMED_CACHE_EVICTION)) {
            strategy = new TimedEvictionStrategy();
        } else if (type.equalsIgnoreCase(CacheConstants.SIZE_CACHE_EVICTION)) {
            strategy = new SizeEvictionStrategy();
        }
        cache.addObserver(observer);
        scheduler.scheduleAtFixedRate(new CacheExpiryWatcher(strategy, cache),CacheConstants.EXPIRY_WATCHER_WAIT_TIME , CacheConstants.EXPIRY_WATCHER_WAIT_TIME, TimeUnit.SECONDS);
        return cache;
    }

    public static void shutdownEvictor(){
        scheduler.shutdown();
    }
}

