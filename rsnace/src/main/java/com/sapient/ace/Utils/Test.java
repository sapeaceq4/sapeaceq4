package com.sapient.ace.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));

        long end = System.nanoTime();

        System.out.printf("elapsed " + TimeUnit.NANOSECONDS.toSeconds(2002947248L));


    }
}
