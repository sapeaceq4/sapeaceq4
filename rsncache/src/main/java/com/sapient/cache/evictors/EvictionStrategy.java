package com.sapient.cache.evictors;

import com.sapient.cache.Cache;

/**
 * Created by Ravdeep Singh
 */

public interface EvictionStrategy {
    void evict(Cache cache);
}
