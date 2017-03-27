package com.sapient.ace.exercise.cache;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class CacheCleaner implements Runnable {
    private Cache c;
    private long reatinTimeInMilli;

    public CacheCleaner(Cache c, long reatinTimeInMilli) {
        this.c = c;
        this.reatinTimeInMilli = reatinTimeInMilli;
    }

    @Override
    public void run() {

    }
}
