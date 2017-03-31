package com.sapient.ace.concurrency.executors.poolWithFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by rsi164 on 3/22/2017.
 */
public class MyThreadPoolExecutorClient {


    public static void main(String[] args) {
        ThreadFactory threadFactory = new MyThreadFactory("RSN");
        testExecutors(threadFactory);
    }

    private static void testExecutors(ThreadFactory threadFactory) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10, threadFactory);

        // create Runnable

        Runnable runnable = () -> {
            throw new RuntimeException("Error in Runnable");
        };

        Runnable runnable2 = () -> {
            throw new RuntimeException("Error in Runnable2");
        };

        Runnable runnable3 = () -> {
            System.out.println("runnable 3");
        };

        Callable<Integer> callable = () -> {
            // System.out.println("A callable runs...");
            throw new Exception("Error in Callable");
        };

        threadPool.submit(runnable);
        threadPool.submit(callable);
        threadPool.execute(runnable2);
        threadPool.execute(runnable3);

        threadPool.shutdown();
        System.out.println("Done.");
    }
}
