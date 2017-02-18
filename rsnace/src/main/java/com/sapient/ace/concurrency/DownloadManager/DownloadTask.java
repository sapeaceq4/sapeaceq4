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
        mark.get().setFileName("downloadedFile-" + Thread.currentThread().getName());
        mark.get().setLinkName("http://ravdeep:8080/" + Thread.currentThread().getName());

        mark.get().setTimeTaken(System.nanoTime());
        while (mark.get().getCompletionStatus() < 100) {
            randomNum = 1 + (int) (Math.random() * 10);
            int value = mark.get().getCompletionStatus() + randomNum;
            mark.get().setCompletionStatus(value < 100 ? value : 100);
            setValue();
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(randomNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeTaken = (System.nanoTime() - mark.get().getTimeTaken());
        long seconds = TimeUnit.NANOSECONDS.toSeconds(timeTaken);

        mark.get().setTimeTaken(seconds);
        mark.get().setSize((int) (seconds * 8));
        mark.get().setFinished(true);
        setValue();
    }
}
