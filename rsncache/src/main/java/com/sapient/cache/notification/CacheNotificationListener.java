package com.sapient.cache.notification;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ravdeep Singh
 */
public class CacheNotificationListener implements Observer {



    private final Notification notification;
    private final Lock lock = new ReentrantLock(true);

    public CacheNotificationListener(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void update(Observable o, Object arg) {
        lock.lock();
        try {

            System.out.printf(notification.getMessage() + "for " + o + " " + arg);
        } finally {
            lock.unlock();
        }
    }
}
