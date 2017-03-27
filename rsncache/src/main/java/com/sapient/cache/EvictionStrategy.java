package com.sapient.cache;

/**
 * Created by Ravdeep Singh
 */

public interface EvictionStrategy {
    void evict(Cache cache);
}
