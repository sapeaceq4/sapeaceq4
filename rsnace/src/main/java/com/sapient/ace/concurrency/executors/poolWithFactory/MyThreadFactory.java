package com.sapient.ace.concurrency.executors.poolWithFactory;

import java.util.concurrent.ThreadFactory;

/**
 * Created by rsi164 on 3/22/2017.
 */
public class MyThreadFactory implements ThreadFactory {
    public static final String DELIMITER = "-";
    private String prefix = "rsn";
    private static int counter = 0;

    final Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            synchronized (this) {
                System.err.println("Uncaught exception in thread '" + t.getName() + "': " + e.getMessage());
            }
        }
    };

    public Thread.UncaughtExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {

        final Thread thread =  new Thread(prefix + DELIMITER + counter);
        thread.setUncaughtExceptionHandler(exceptionHandler);
        return thread;
    }
}
