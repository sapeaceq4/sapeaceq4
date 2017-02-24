package com.sapient.ace.exercise13022017.cache;

import java.security.Key;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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


    public V putVal(Key Key, CacheElement<V> value){
        if (value.getTTL()>0){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(value.getTTL()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //call expiry
            },"TTL_Expiry_Thread-"+Key).start();
        }
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
