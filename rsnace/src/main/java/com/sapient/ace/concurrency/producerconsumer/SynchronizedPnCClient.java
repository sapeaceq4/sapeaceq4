package com.sapient.ace.concurrency.producerconsumer;

import com.sapient.ace.profiling.memoryleak.ThreadDumper;

public class SynchronizedPnCClient {
    public static void main(String[] args) throws InterruptedException {
        EventStorage storage = new EventStorage();

        Thread producer = new Thread(new EventProducer(storage));
        Thread consumer = new Thread(new EventConsumer(storage));

        producer.start();
        consumer.start();
        while (true){
            System.out.println("Status");
            System.out.println(producer.getState() + " " + consumer.getState() );
            Thread.sleep(2000);
        }

//        producer.join();
//        consumer.join();
//

    }

}
