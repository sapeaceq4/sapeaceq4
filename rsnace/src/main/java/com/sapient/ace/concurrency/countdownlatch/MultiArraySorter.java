package com.sapient.ace.concurrency.countdownlatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ravdeep Singh on 13-02-2017.
 */
public class MultiArraySorter {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int[] a1 = {2, 4, 5, 32, 9, 54, 8, 34, 7};
        int[] a2 = {65, 234, 8, 1, 3, 4, 5, 13, 78, 249, 6};
        int[] a3 = {98, 95, 49, 35, 809, 213};
        int[] a4 = {78, 4598, 43, 67, 890, 43, 12, 34, 54};
        int[] a5 = {78, 5, 43, 4523, 67789, 23, 65, 7, 43423, 56, 67};
        ArraySorter sorter1 = new ArraySorter(a1, countDownLatch);
        ArraySorter sorter2 = new ArraySorter(a2, countDownLatch);
        ArraySorter sorter3 = new ArraySorter(a3, countDownLatch);
        ArraySorter sorter4 = new ArraySorter(a4, countDownLatch);
        ArraySorter sorter5 = new ArraySorter(a5, countDownLatch);

        Thread t1 = new Thread(sorter1, "Thread1");
        Thread t2 = new Thread(sorter2, "Thread2");
        Thread t3 = new Thread(sorter3, "Thread3");
        Thread t4 = new Thread(sorter4, "Thread4");
        Thread t5 = new Thread(sorter5, "Thread5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
        System.out.println(Arrays.toString(a5));
        //Now Merge

    }
}
