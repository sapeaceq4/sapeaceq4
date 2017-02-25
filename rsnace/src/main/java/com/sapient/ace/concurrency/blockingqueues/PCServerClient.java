package com.sapient.ace.concurrency.blockingqueues;

import java.util.concurrent.*;

/**
 * Created by Ravdeep Singh on 2/10/2017.
 */
public class PCServerClient {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<QueueElement> queue = new LinkedBlockingQueue<QueueElement>();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Producer []producers  = new Producer[10];
        Consumer []consumers  = new Consumer[10];

        for (int i = 0; i <10 ; i++) {
            producers[i] = new Producer(queue);
            consumers[i] = new Consumer(queue);
        }

        for (int i = 0; i <10 ; i++) {
            executorService.execute(producers[i]);
            executorService.execute(consumers[i]);
        }

        executorService.awaitTermination(2, TimeUnit.MINUTES);
        executorService.shutdown();
    }
}
