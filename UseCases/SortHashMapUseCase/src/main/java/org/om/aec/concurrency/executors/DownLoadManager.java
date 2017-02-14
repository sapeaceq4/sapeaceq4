package org.om.aec.concurrency.executors;

import java.util.concurrent.Callable;

import org.om.aec.concurrency.exchanger.future.FutureImpl;
import org.om.aec.concurrency.exchanger.future.IFuture;
import org.om.aec.utils.AppUtils;

public class DownLoadManager
{
	private ThreadPool threadPool;
	public DownLoadManager()
	{
		threadPool = new ThreadPool(2);
	}
	
	void putOnDownLoad(DownLoadTask downLoadTask)
	{
		IFuture<DownloadResult> downLoadFuture = threadPool.submit(new DownLoadTask());
		int progressPercentage = downLoadFuture.getProgressPercentage();
		System.out.println(progressPercentage);
	}
	
	public static void main(String[] args) 
	{
		DownLoadManager downLoadManager = new DownLoadManager();
		downLoadManager.putOnDownLoad(new DownLoadTask());
	}
}



class DownLoadTask implements Callable<DownloadResult>
{
	@Override
	public DownloadResult call() throws Exception 
	{
		System.out.println("Download task started..."+ this);
		FutureImpl<DownloadResult> future = new FutureImpl<DownloadResult>(this);
		AppUtils.asleep(10);
		future.setProgressPercentage(10);
		AppUtils.asleep(20);
		future.setProgressPercentage(30);
		AppUtils.asleep(50);
		future.setProgressPercentage(70);
		return new DownloadResult();
	}
}

class DownloadResult
{
	DownloadResult()
	{
		
	}
}

