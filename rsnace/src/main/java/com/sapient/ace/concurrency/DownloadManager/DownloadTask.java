package com.sapient.ace.concurrency.DownloadManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 16-02-2017.
 */
public class DownloadTask extends Observable implements Runnable {

    private String downLoadLink;

    public DownloadTask(String downLoadLink) {
        this.downLoadLink = downLoadLink;
    }

    ThreadLocal<DownloadItem> mark = new ThreadLocal<DownloadItem>() {
        @Override
        protected DownloadItem initialValue() {
            return new DownloadItem(downLoadLink);
        }
    };

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    public void setValue() {
        setChanged();
        notifyObservers(mark.get());
    }

    @Override
    public void run() {
        int randomNum;
        mark.get().setFileName("downLoadLink-" +Thread.currentThread().getName() );
        mark.get().setTimeTaken(System.nanoTime());
        while (mark.get().getCompletionStatus() < 100) {
            randomNum = 1 + (int) (Math.random() * 20);
            int value = mark.get().getCompletionStatus() + randomNum;
            mark.get().setCompletionStatus(value < 100 ? value : 100);
            setValue();
            System.out.println("status " + mark.get().getCompletionStatus());
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(randomNum));
//                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeTaken = System.nanoTime() - mark.get().getTimeTaken();
        mark.get().setTimeTaken(timeTaken);

        mark.get().setSize((int) (timeTaken/1024));

    }
}
