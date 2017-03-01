package com.sapient.ace.Utils;

import com.sapient.ace.spring.model.Employee;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Test {
    private static Lock lock = new ReentrantLock();
    private static int i;

    public static void main(String[] args) throws InterruptedException {
      /*  long start = System.nanoTime();
        Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));

        long end = System.nanoTime();
            Thread test = new Thread();
        System.out.printf("elapsed " + TimeUnit.NANOSECONDS.toSeconds(2002947248L));
        testlock();*/

        String str1 = new String("Test");
        System.out.println(str1.intern());

        String s1 = "Rakesh";
        String s2 = "Rakesh";
        String s3 = "Rakesh".intern();
        String s4 = new String("Rakesh");
        String s5 = new String("Rakesh").intern();

        if ( s1 == s2 ){
            System.out.println("s1 and s2 are same");  // 1.
        }

        if ( s1 == s3 ){
            System.out.println("s1 and s3 are same" );  // 2.
        }

        if ( s1 == s4 ){
            System.out.println("s1 and s4 are same" );  // 3.
        }

        if ( s1 == s5 ){
            System.out.println("s1 and s5 are same" );  // 4.
        }

        Map<Employee,String> map = new TreeMap();
        map.put(null,"string");



    }

    private static void testlock() {

        i++;
        lock.lock();
        if (i < 10)
            testlock();
        lock.unlock();
    }
}
