package com.sapient.ace.exercise13022017.cache;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class CacheElement<T> {
    T element;
    boolean expire;
    long lastAccessTime;
    long creationTime;
    int hitcount;

    public CacheElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
