package com.sapient.ace.concurrency.blockingqueues;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/10/2017.
 */
public class Producer implements Runnable {
    private BlockingQueue<QueueElement> q = null;

    public Producer(BlockingQueue q) {
        this.q = q;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1 + (int) (Math.random() * 10)));
                QueueElement e = new QueueElement("String - " + new Date(System.currentTimeMillis()));
                q.put(e);
                System.out.println("Producer " + Thread.currentThread().getName() + " created element " + e);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
