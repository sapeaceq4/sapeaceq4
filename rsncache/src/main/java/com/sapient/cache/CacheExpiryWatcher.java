package com.sapient.cache;

import com.sapient.cache.evictors.EvictionStrategy;

/**
 * Created by Ravdeep Singh
 */

public class CacheExpiryWatcher implements Runnable {
    private final EvictionStrategy eviction;
    private final Cache targetCache;

    public CacheExpiryWatcher(EvictionStrategy eviction, Cache targetCache) {
        this.eviction = eviction;
        this.targetCache = targetCache;
    }

    public void run() {
            System.out.println("Executing ExpiryWatcher");
            eviction.evict(targetCache);
    }
}
