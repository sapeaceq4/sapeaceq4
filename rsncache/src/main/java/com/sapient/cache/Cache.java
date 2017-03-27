package com.sapient.cache;

import com.sapient.cache.utils.CacheConstants;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ravdeep Singh
 */
public class Cache<K, V> extends Observable {
    private int capacity;
    private K key;

    private ConcurrentHashMap<K, CacheElement<V>> backingMap;

    //1024 is load factor
    public Cache(int initCapacity) {
        capacity = initCapacity;
        backingMap = new ConcurrentHashMap<K, CacheElement<V>>(initCapacity + CacheConstants.CACHE_LOAD_FACTOR);
    }

    public void put(K key, CacheElement<V> value) {
        backingMap.put(key, value);
    }

    public CacheElement<V> get(K key) {
        System.out.println("cache get");
        CacheElement<V> value = backingMap.get(key);
        if (value == null)
            return null;
        else if (value.isExpired()) {
            backingMap.remove(key);
            notifyObservers(value);
            System.out.println("expired in get");
        } else if (value.getTimeToLive() != 0) {
            Date expiryTime = new Date();
            Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(expiryTime);
            cal.add(cal.SECOND, value.getTimeToLive());
            value.setDateOfExpiry(cal.getTime());
            System.out.println("extended time");
        }
        return value;
    }

    public CacheElement<V> remove(K key) {
        return backingMap.remove(key);
    }

    public void removeExpired() {
        System.out.println("before expiring"+backingMap);
        for (Map.Entry<K, CacheElement<V>> entry : backingMap.entrySet()) {
            if (entry.getValue().isExpired()) {
                System.out.println("cache removing expire");
                notifyObservers(entry.getValue());
                backingMap.remove(entry.getKey());
            }
        }
        System.out.println("after expiring"+backingMap);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return backingMap.size();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }
}
