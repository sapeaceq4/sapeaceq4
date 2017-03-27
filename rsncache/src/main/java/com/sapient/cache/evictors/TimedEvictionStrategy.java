package com.sapient.cache.evictors;

import com.sapient.cache.Cache;

/**
 * Created by Ravdeep Singh
 */

public class TimedEvictionStrategy implements EvictionStrategy {
    public void evict(Cache cache) {
        cache.removeExpired();
    }
}
