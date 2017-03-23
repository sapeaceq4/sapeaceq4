package com.sapient.ace.threads;

/**
 * Created by Ravdeep Singh on 3/17/2017.
 */
public class ThreadTestSyncSleep {

    public static void main(String[] args) {
        Object obj = new Object();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                    System.out.println("State for thread before is " + Thread.currentThread().getState());
                    System.out.println("State for thread before is " + threads[90].getState());
                    synchronized (obj) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("State for thread after is " + threads[90].getState());
                    }

            }
                    , "Thread-" + i);
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }

    }
}
