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

public class CopyOnWriteTest {

    private static void f( List l ) {
        l.add( 2 );
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List copyOnWriteList = new CopyOnWriteArrayList();
        List simpleList = new ArrayList();
        copyOnWriteList.add( 1 );
        simpleList.add( 1 );
        new Thread(() -> {
            copyOnWriteList.add(5);
        }).start();
        Iterator copyOnWriteIterator1 = copyOnWriteList.iterator();
        Iterator simpleListIterator1 = simpleList.iterator();
        f( copyOnWriteList );
        Iterator copyOnWriteIterator2 = copyOnWriteList.iterator();
        Iterator simpleListIterator2 = simpleList.iterator();
        // debug point on the output line just below
//        copyOnWriteIterator1.remove();
        System.out.println(copyOnWriteList);


    }

}