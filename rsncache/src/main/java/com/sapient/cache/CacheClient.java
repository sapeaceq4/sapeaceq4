package com.sapient.cache;

import com.sapient.cache.manager.CacheManager;
import com.sapient.cache.notification.CacheNotificationListener;
import com.sapient.cache.notification.Notification;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 27-03-2017.
 */
public class CacheClient {
    public static void main(String[] args) throws InterruptedException {
        Notification notification = new Notification("Updated value ");
        CacheNotificationListener listener = new CacheNotificationListener(notification);
        Cache cache = CacheManager.getCache(10, "time", listener);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = new String("key-" + i);
                CacheElement<Long> co = new CacheElement<>(Long.valueOf(i), random(10,1));
                cache.put(s, co);
            }

        });
        t1.start();

        Thread.sleep(5000);
        CacheElement<Long> o =  cache.get("key-5");
        if (o == null)
            System.out.println("Main: FAILURE!  Object not Found.");
        else
            System.out.println("Main: SUCCESS! " + (o.toString()));

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CacheManager.shutdownEvictor();
    }

    private static int random(int max, int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
