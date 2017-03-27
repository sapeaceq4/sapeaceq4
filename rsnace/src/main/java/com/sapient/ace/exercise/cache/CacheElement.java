package com.sapient.ace.exercise.cache;

import java.util.Date;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class CacheElement<T> implements Cacheable{
    private Object id;
    private Date expiryTime;
    private T value;

    public CacheElement(Object id, T value) {
        this.id = id;
        this.value = value;
    }

    public CacheElement(Object id, T Value, int minutesToLive) {
        this.id = id;
        this.value = value;
        // minutesToLive of 0 means it lives on indefinitely.
        if (minutesToLive != 0) {
            expiryTime = new java.util.Date();
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(expiryTime);
            cal.add(cal.SECOND, minutesToLive);
            expiryTime = cal.getTime();
        }
    }

    @Override
    public boolean isExpired()
    {
        // Remember if the minutes to live is zero then it lives forever!
        if (expiryTime != null)
        {
            // date of expiration is compared.
            if (expiryTime.before(new java.util.Date()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else // This means it lives forever!
            return false;
    }


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}