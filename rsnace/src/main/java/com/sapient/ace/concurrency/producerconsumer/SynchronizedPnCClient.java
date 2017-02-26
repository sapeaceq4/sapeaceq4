package com.sapient.ace.concurrency.producerconsumer;

public class SynchronizedPnCClient {
    public static void main(String[] args) throws InterruptedException {
        EventStorage storage = new EventStorage();

        Thread producer = new Thread(new EventProducer(storage));
        Thread consumer = new Thread(new EventConsumer(storage));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

}
