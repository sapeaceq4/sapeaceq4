package com.sapient.cache;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ravdeep Singh
 */

public class CacheElement<T> implements Cacheable{

    private volatile  Date dateOfExpiry;
    private final T value;
    private final int timeToLive;

    public CacheElement(T value) {
        this(value,0);
    }

    //timeTolive in seconds, 0 for for disabling expiration
    public CacheElement(T value, int timeToLive) {
        this.value = value;
        this.timeToLive = timeToLive;
        if (timeToLive != 0) {
            dateOfExpiry = new java.util.Date();
            Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(dateOfExpiry);
            cal.add(Calendar.SECOND, timeToLive);
            dateOfExpiry = cal.getTime();
        }
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

    public void setDateOfExpiry(final Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    public boolean isExpired() {
        return dateOfExpiry != null && dateOfExpiry.before(new Date());
    }
}
