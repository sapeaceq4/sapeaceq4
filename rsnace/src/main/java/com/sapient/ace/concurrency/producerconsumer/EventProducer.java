package com.sapient.ace.concurrency.producerconsumer;

import com.sapient.ace.profiling.memoryleak.ThreadDumper;

public class EventProducer implements Runnable {
    EventStorage storage;

    public EventProducer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
