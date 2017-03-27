package com.sapient.cache;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;

/**
 * Created by Ravdeep Singh
 */

public class CacheElement<T> implements Cacheable{

    private volatile  Date dateOfExpiry;
    private final T value;
    private volatile int timeToLive;

    public CacheElement(T value) {
        this.value = value;
    }

    //timeTolive in seconds
    public CacheElement(T value, int timeToLive) {
        this.value = value;
        this.timeToLive = timeToLive;
        if (timeToLive != 0) {
            dateOfExpiry = new java.util.Date();
            Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(dateOfExpiry);
            cal.add(cal.SECOND, timeToLive);
            dateOfExpiry = cal.getTime();
        }
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;

    }

    @Override
    public String toString() {
        return "CacheElement{" +
                "dateOfExpiry=" + dateOfExpiry +
                ", value=" + value +
                ", timeToLive=" + timeToLive +
                '}';
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    public boolean isExpired() {
        if (dateOfExpiry != null && dateOfExpiry.before(new java.util.Date())) {
            return true;
        } else {
            return false;
        }
    }
}
