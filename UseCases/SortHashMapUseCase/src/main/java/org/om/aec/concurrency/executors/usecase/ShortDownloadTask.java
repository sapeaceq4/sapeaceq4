package org.om.aec.concurrency.executors.usecase;

import org.om.aec.utils.AppUtils;

public class ShortDownloadTask extends DownloadTask
{
	public ShortDownloadTask(int taskId)
	{
		super(taskId);
	}
	
	@Override
	protected DownloadEvent start() 
	{
		long startTime = System.currentTimeMillis();
		AppUtils.asleep(10);
		AppUtils.asleep(100);
		return new DownloadCompletedEvent(taskId, true, "Download task completed",
				(System.currentTimeMillis() - startTime));
	}
}
