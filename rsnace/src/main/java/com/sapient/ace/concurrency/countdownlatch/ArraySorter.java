package com.sapient.ace.concurrency.countdownlatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ravdeep Singh on 13-02-2017.
 */
public class ArraySorter implements Runnable {
    int[] array;
    CountDownLatch latch;

    public ArraySorter(int[] array, CountDownLatch latch) {
        this.array = array;
        this.latch = latch;
    }


    @Override
    public void run() {
        System.out.printf("\nThread %s sorting array", Thread.currentThread().getName());
        Arrays.sort(array);
        System.out.printf("\n Thread %s completed", Thread.currentThread().getName());
        latch.countDown();

    }
}
