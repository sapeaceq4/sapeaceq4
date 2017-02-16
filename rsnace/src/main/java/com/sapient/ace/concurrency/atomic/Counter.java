package com.sapient.ace.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ravdeep Singh on 16-02-2017.
 */
class Counter {

    private AtomicInteger count = new AtomicInteger(0);

    public void incrementCount() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}