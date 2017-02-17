package com.sapient.ace.concurrency.DownloadManager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ravdeep Singh on 2/17/2017.
 */
public class DownloadClient{
    public static void main(String[] args) {
        final int count = 10;
        DownloadManager manager = new DownloadManager();
        Thread threads [] = new Thread[count];
        for (int i = 0; i < count; i++) {
            DownloadTask downloadTask = new DownloadTask("URL LINK-" + i);
            downloadTask.addObserver(manager);
            threads[i] = new Thread(downloadTask,"Downloader thread-"+i);

        }

        for (int i = 0; i < count; i++) {
            threads[i].start();
        }
    }

}
