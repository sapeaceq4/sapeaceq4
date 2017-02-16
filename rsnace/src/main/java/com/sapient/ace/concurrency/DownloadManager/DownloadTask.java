package com.sapient.ace.concurrency.DownloadManager;

import java.util.Observable;

/**
 * Created by Ravdeep Singh on 16-02-2017.
 */
public class DownloadTask extends Observable implements Runnable {

    private int status = 0;

    public DownloadTask(int status) {
        this.status = status;
    }

    public void setValue(int status) {
        this.status = status;
        setChanged();
        notifyObservers();
    }

    public int getValue() {
        return status;
    }

    @Override
    public void run() {

    }
}
