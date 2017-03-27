package com.sapient.cache;

/**
 * Created by Ravdeep Singh
 */

public class TimedEvictionStrategy implements EvictionStrategy {
    public void evict(Cache cache) {
        cache.removeExpired();
    }
}
