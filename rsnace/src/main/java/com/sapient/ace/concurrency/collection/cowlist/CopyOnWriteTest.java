package com.sapient.ace.concurrency.collection.cowlist;

/**
 * Created by Ravdeep Singh on 04-03-2017.
 */
// CopyOnWriteTest.java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest {

    private static void f(List l) {
        l.add(2);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List copyOnWriteList = new CopyOnWriteArrayList();
        copyOnWriteList.add(1);
        System.out.println(copyOnWriteList);
        new Thread(() -> {
            System.out.println(copyOnWriteList);
            copyOnWriteList.add(5);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(copyOnWriteList);
        }).start();
        Iterator copyOnWriteIterator1 = copyOnWriteList.iterator();
        f(copyOnWriteList);
        Iterator copyOnWriteIterator2 = copyOnWriteList.iterator();
        // debug point on the output line just below
//        copyOnWriteIterator1.remove();

//        copyOnWriteIterator2.remove();
        System.out.println(copyOnWriteList);


    }

}