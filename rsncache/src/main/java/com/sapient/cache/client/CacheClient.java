package com.sapient.cache.client;

import com.sapient.cache.Cache;
import com.sapient.cache.CacheElement;
import com.sapient.cache.manager.CacheManager;
import com.sapient.cache.notification.CacheNotificationListener;
import com.sapient.cache.notification.Notification;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh
 */

public class CacheClient {
    public static void main(String[] args) throws InterruptedException {
        Notification notification = new Notification("Updated value ");
        CacheNotificationListener listener = new CacheNotificationListener(notification);
        Cache<String, Long > cache = CacheManager.MANAGER.getCache(10, "time", listener);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "key-" + i;
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

        CacheManager.MANAGER.shutdownEvictor();
    }

    private static int random(int max, int min) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
