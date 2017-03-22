package com.sapient.ace.Utils;

import java.util.concurrent.*;

/**
 * Created by rsi164 on 3/22/2017.
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(1 / 0);
            }
        };

       Future t =  executorService.submit(runnable);
        try {
            System.out.println(t.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
