package com.sapient.ace.concurrency.executors.poolWithFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rsi164 on 3/22/2017.
 */
public class MyThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    public static final String CLASS_NAME = MyThreadFactory.class.getSimpleName();
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    public static final String DELIMITER = "-";
    private String prefix = "rsn";

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

    public MyThreadFactory() {
        this(CLASS_NAME);
    }

    public MyThreadFactory(String prefix) {
        this(new ThreadGroup(CLASS_NAME), prefix);
    }

    public MyThreadFactory(ThreadGroup group, String prefix) {
        this.group = group;
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable runnable) {

        final Thread thread = new Thread(runnable, "pool" + DELIMITER + poolNumber.getAndIncrement() + DELIMITER +
                prefix +
                DELIMITER + threadNumber.getAndIncrement());
        thread.setUncaughtExceptionHandler(exceptionHandler);
        return thread;
    }
}
