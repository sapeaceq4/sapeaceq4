package com.sapient.ace.concurreny.blockingqueues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/10/2017.
 */
public class PCServerClient {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<QueueElement> queue = new LinkedBlockingQueue<QueueElement>();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
    }
}
