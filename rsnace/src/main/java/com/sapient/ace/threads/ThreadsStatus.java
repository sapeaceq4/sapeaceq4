package com.sapient.ace.threads;

import com.sapient.ace.profiling.memoryleak.ThreadDumper;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 20-03-2017.
 */
public class ThreadsStatus {
    private static int i =5;
    private static Thread t1, t2, t3;

    public static void main(String[] args) {

        MyTask task = new MyTask();
        t1 = new Thread(task, "t1");
        t2 = new Thread(task, "t2");
        t3 = new Thread(task, "t3");

        Thread t4 = new Thread(task, "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        while (true) {
            System.out.println("Status");
            System.out.println(t1.getState() + " " + t2.getState() + " " + t3.getState() + " ");
                try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static class MyTask implements Runnable {

        private Object obj = new Object();

        @Override
        public void run() {

            if (Thread.currentThread().getName().equals("t4")){
                callYOU();
            }else
                callME();
        }

        private synchronized void callYOU() {
            System.out.println(Thread.currentThread().getState());
            notify();
        }

        private synchronized void callME() {

                while (true) {

                    System.out.println("Lock acquired by " + Thread.currentThread().getName() +Thread.currentThread().getState());
                    try {
                        wait();
                        System.out.println("wait called" + Thread.currentThread().getName() +Thread.currentThread().getState());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Status");
                    System.out.println(t1.getState() + " " + t2.getState() + " " + t3.getState() + " ");
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(i);
                }
        }
    }
}
