package com.sapient.ace.concurrency.atomic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ravdeep Singh on 16-02-2017.
 */
public class ConcurrentCounter {

    public static void main(String[] args) throws InterruptedException {

        final Counter counter = new Counter();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            threads.add(new Thread(new MyCounterTask(counter), "Thread-" + x));
        }

        Iterator i1 = threads.iterator();
        while (i1.hasNext()) {
            Thread mt = (Thread) i1.next();
            mt.start();
        }

        Iterator i2 = threads.iterator();
        while (i2.hasNext()) {
            Thread mt = (Thread) i2.next();
            mt.join();
        }

        System.out.println("Count: " + counter.getCount());
    }
}

class MyCounterTask implements Runnable {
    Counter counter;

    MyCounterTask(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
//            System.out.println("Executing thread " + Thread.currentThread().getName());
            counter.incrementCount();
            System.out.println("Counter value is " + counter.getCount()+" "+Thread.currentThread().getName());
        }
    }
}