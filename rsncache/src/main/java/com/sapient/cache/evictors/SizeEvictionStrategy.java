package com.sapient.cache.evictors;

import com.sapient.cache.Cache;
import com.sapient.cache.utils.CacheConstants;

/**
 * Created by Ravdeep Singh
 */
public class SizeEvictionStrategy implements EvictionStrategy {

    public void evict(Cache cache) {
        if(cache.getSize() + CacheConstants.CACHE_LOAD_FACTOR >= cache.getCapacity() ){
            cache.removeExpired();
        }
    }
}
