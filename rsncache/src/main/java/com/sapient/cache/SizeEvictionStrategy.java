package com.sapient.cache;

import com.sapient.cache.utils.CacheConstants;

/**
 * Created by Ravdeep Singh
 */
public class SizeEvictionStrategy implements EvictionStrategy {

    public void evict(Cache cache) {
        if(cache.getSize() + CacheConstants.CACHE_LOAD_FACTOR == cache.getCapacity() ){
            cache.removeExpired();
        }
    }
}
