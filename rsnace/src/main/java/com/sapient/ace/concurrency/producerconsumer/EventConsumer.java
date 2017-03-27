package com.sapient.ace.concurrency.producerconsumer;

public class EventConsumer implements Runnable {
    EventStorage storage;

    public EventConsumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.get();

        }
    }
}
