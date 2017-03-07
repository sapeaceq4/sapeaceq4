package com.sapient.ace.profiling.memoryleak;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 07-03-2017.
 */

public class Adder {

    public long addIncremental(long l) {
        Long sum = 0L;
        sum = sum + l;
        return sum;
    }

    public static void main(String[] args) {
        Adder adder = new Adder();
        for (long i = 0; i < 10000; i++) {
            adder.addIncremental(i);

        }

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}