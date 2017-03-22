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

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                // System.out.println("A runnable runs...");
                throw new RuntimeException("Error in Runnable");
            }
        };

        // create Callable

        Callable<Integer> callable = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                // System.out.println("A callable runs...");
                throw new Exception("Error in Callable");
            }
        };

        // a) submitting Runnable to threadpool
        threadPool.submit(runnable);

        // b) submit Callable to threadpool
        threadPool.submit(callable);

        // c) create a thread for runnable manually
//        final Thread thread_r = new Thread(runnable, "manually-created-thread");
//        thread_r.setUncaughtExceptionHandler(threadFactory.);
//        thread_r.start();

        threadPool.shutdown();
        System.out.println("Done.");
    }
}
