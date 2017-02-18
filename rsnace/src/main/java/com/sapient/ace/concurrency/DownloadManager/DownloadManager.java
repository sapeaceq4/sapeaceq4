package com.sapient.ace.concurrency.DownloadManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ravdeep Singh on 2/17/2017.
 */

public class DownloadManager implements Observer {
    Lock lock = new ReentrantLock();

    @Override
    public void update(Observable o, Object arg) {
        lock.lock();
        DownloadItem item = (DownloadItem) arg;
        System.out.println("------------- Download Summary --------------");
        System.out.println("Download Item:  " + Thread.currentThread().getName());
        System.out.println("Download Status: " + item.getCompletionStatus() + "%");
        System.out.println("Download FileName: " + item.getFileName());
        System.out.println("Download URL :" + item.getLinkName());
        if (item.isFinished()) {
            System.out.println("Download Time Taken " + item.getTimeTaken() + " seconds");
            System.out.println("Download Size :" + item.getSize() + " KB");
        }
        System.out.println("------------- Summary Finished --------------");
        lock.unlock();

    }

}
