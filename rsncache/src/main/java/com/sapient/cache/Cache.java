package com.sapient.cache;

import com.sapient.cache.exception.CacheException;
import com.sapient.cache.utils.CacheConstants;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ravdeep Singh
 */
public class Cache<K, V> extends Observable {
    private final int capacity;
    private final ConcurrentHashMap<K, CacheElement<V>> backingMap;

    //1024 is load factor
    public Cache(int initCapacity) {
        capacity = initCapacity;
        backingMap = new ConcurrentHashMap<>(initCapacity + CacheConstants.CACHE_LOAD_FACTOR);
    }

    public void put(K key, CacheElement<V> value) {
        if(backingMap.size()==capacity){
            throw new CacheException("Not able to add objects. Cache is full");
        }
        backingMap.put(key, value);
    }

    public CacheElement<V> get(K key) {
        CacheElement<V> value = backingMap.get(key);
        if (value == null)
            return null;
        else if (value.isExpired()) {
                backingMap.remove(key);
                setChanged();
                notifyObservers(value);
        } else if (value.getTimeToLive() != 0) {
                Date expiryTime = new Date();
                Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(expiryTime);
                cal.add(Calendar.SECOND, value.getTimeToLive());
                value.setDateOfExpiry(cal.getTime());
        }
        return value;
    }

    public CacheElement<V> remove(K key) {
        return backingMap.remove(key);
    }

    public void clear() {
         backingMap.clear();
    }
    public void removeExpired() {
        System.out.println("before expiring" + backingMap);
        for (Map.Entry<K, CacheElement<V>> entry : backingMap.entrySet()) {
            if (entry.getValue().isExpired()) {
                setChanged();
                notifyObservers(entry.getValue());
                backingMap.remove(entry.getKey());
            }
        }
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
    public synchronized int countObservers() {
        return super.countObservers();
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
