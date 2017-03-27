package com.sapient.cache;

/**
 * Created by Ravdeep Singh
 */

public class CacheExpiryWatcher implements Runnable {
    private EvictionStrategy eviction;
    private Cache targetCache;

    public CacheExpiryWatcher(EvictionStrategy eviction, Cache targetCache) {
        this.eviction = eviction;
        this.targetCache = targetCache;
    }

    public void run() {
            System.out.println("Executing ExpiryWatcher");
            eviction.evict(targetCache);
    }
}
