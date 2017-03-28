package com.sapient.cache.utils;

/**
 * Created by Ravdeep Singh
 */

// To be loaded from prop
public interface CacheConstants {
    int EXPIRY_WATCHER_WAIT_TIME = 10;
    int CACHE_LOAD_FACTOR = 1024;
    String TIMED_CACHE_EVICTION = "TIME";
    String SIZE_CACHE_EVICTION = "SIZE";
}
