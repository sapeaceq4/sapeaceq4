package org.om.aec.concurrency.executors.usecase;

import org.om.aec.utils.CommonTools;

public class LargeDownloadTask extends DownloadTask
{
	public LargeDownloadTask(int taskId)
	{
		super(taskId);
	}
	
	@Override
	protected DownloadEvent start() 
	{
		long startTime = System.currentTimeMillis();
		CommonTools.asleep(10);
		CommonTools.asleep(100);
		CommonTools.asleep(1000);
		return new DownloadCompletedEvent(taskId, true, "Download task completed",
				(System.currentTimeMillis() - startTime));
	}
}
