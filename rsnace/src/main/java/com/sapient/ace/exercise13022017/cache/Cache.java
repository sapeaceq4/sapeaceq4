package com.sapient.ace.exercise13022017.cache;

import java.security.Key;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class Cache <K,V>{
    private Map<K,CacheElement<V>> cache = new ConcurrentHashMap<>();

    public Map<K, CacheElement<V>> getCache() {
        return cache;
    }

    public V getVal(K key){
        return null;
    }


    public V putVal(Key Key, V value){
        return null;
    }

    public V removeVal(Key Key){
        return null;
    }

    public void clear(){
        cache.clear();
    }

    public Collection<CacheElement<V>> getAllValues(){
        return cache.values();
    }
}
