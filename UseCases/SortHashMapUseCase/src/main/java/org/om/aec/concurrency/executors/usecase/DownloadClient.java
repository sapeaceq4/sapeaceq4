package org.om.aec.concurrency.executors.usecase;

import java.util.concurrent.LinkedBlockingQueue;

import org.om.aec.utils.CommonTools;

public class DownloadClient 
{
	private DownloadManager  downloadManager;
	
	public DownloadClient(DownloadManager  downloadManager)
	{
		this.downloadManager = downloadManager;
	}
	
	class DummyDownloadRequestInitiator implements Runnable
	{
		private int noOfRequestInitiate;
		DummyDownloadRequestInitiator(int noOfRequestInitiate)
		{
			this.noOfRequestInitiate = noOfRequestInitiate;
		}
		@Override
		public void run() 
		{
			while(noOfRequestInitiate-- > 0)
			{
				downloadManager.putOnDownLoad(new ShortDownloadTask(noOfRequestInitiate));
				downloadManager.putOnDownLoad(new LargeDownloadTask(--noOfRequestInitiate));
				CommonTools.asleep(200);
			}
		}
	}
	
	public void start()
	{
		new Thread(new DummyDownloadRequestInitiator(10), "DummyDownloadRequestInitiatorThread").start();
	}
	
	public static void main(String[] args) 
	{
		DownloadManager downloadManager = new DownloadManager(new LinkedBlockingQueue<DownloadEvent>());
		downloadManager.init();
		new DownloadClient(downloadManager).start();
	}
}
