package com.sapient.ace.concurrency.producerconsumer;

public class EventProducer implements Runnable {
    EventStorage storage;

    public EventProducer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
