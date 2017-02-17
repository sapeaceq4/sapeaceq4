package com.sapient.ace.concurrency.DownloadManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/17/2017.
 */

public class DownloadManager implements Observer, Runnable {

    //implement listener
    BlockingQueue<DownloadItem> queue = new LinkedBlockingQueue<>();

    @Override
    public void update(Observable o, Object arg) {
        DownloadItem item = (DownloadItem) arg;
/*
        System.out.println("------------- Download Summary --------------");
        System.out.println("Download Status " + item.getCompletionStatus());
        System.out.println("Download FileName " + item.getFileName());
        System.out.println("Download " + item.getLinkName());
        if (item.getCompletionStatus() == 100) {
//            System.out.println("Download Time Taken " + item.getTimeTaken());
//            System.out.println("Download Time Taken " + TimeUnit.SECONDS.toSeconds(item.getTimeTaken()));
            System.out.println("Download Time Taken " + TimeUnit.MINUTES.convert(item.getTimeTaken(), TimeUnit.NANOSECONDS));
        }
//        System.out.println("Download Time Taken " + TimeUnit.MILLISECONDS.toMinutes(((DownloadItem) arg).getTimeTaken()));
        */
        try {
            queue.put(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        System.out.println("------------- Download Summary --------------");
        while (true) {
            try {
                DownloadItem item = queue.take();
                System.out.println("Download Status " + item.getCompletionStatus());
                System.out.println("Download FileName " + item.getFileName());
                System.out.println("Download " + item.getLinkName());
                if (item.getCompletionStatus() == 100) {
//            System.out.println("Download Time Taken " + item.getTimeTaken());
//            System.out.println("Download Time Taken " + TimeUnit.SECONDS.toSeconds(item.getTimeTaken()));
                    System.out.println("Download Time Taken " + TimeUnit.MINUTES.convert(item.getTimeTaken(), TimeUnit.NANOSECONDS));
                }
//        System.out.println("Download Time Taken " + TimeUnit.MILLISECONDS.toMinutes(((DownloadItem) arg).getTimeTaken()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
