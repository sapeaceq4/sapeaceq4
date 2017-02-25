package com.sapient.ace.concurrency.blockingqueues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/10/2017.
 */
public class Consumer implements Runnable {

    private BlockingQueue<QueueElement> q = null;

    public Consumer(BlockingQueue q) {
        this.q = q;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {

                Thread.sleep(TimeUnit.SECONDS.toMillis(1 + (int) (Math.random() * 10)));
                QueueElement element = q.take();
                System.out.println("Consumer "+Thread.currentThread().getName()+" consumed element " + element);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
