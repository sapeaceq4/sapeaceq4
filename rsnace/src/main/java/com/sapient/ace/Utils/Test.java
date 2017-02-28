package com.sapient.ace.Utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Test {
    private static Lock lock = new ReentrantLock();
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));

        long end = System.nanoTime();
            Thread test = new Thread();
        System.out.printf("elapsed " + TimeUnit.NANOSECONDS.toSeconds(2002947248L));
        testlock();
    }

    private static void testlock() {

        i++;
        lock.lock();
        if (i < 10)
            testlock();
        lock.unlock();
    }
}
