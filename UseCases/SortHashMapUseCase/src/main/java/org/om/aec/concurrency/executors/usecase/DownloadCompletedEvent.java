package org.om.aec.concurrency.executors.usecase;

public class DownloadCompletedEvent extends DownloadEvent
{
	private long timeTakenInMillis;
	DownloadCompletedEvent(int eventId, boolean isCompleted, String message, long timeTakenInMillis) 
	{
		super(eventId, isCompleted, message);
		this.timeTakenInMillis = timeTakenInMillis;
	}
	@Override
	public String toString() {
		return "DownloadCompletedEvent [eventId=" + getEventId()
				+ ", message=" + getMessage() + ", isCompleted="
				+ isCompleted() + ", timeTakenInMillis=" + timeTakenInMillis
				+ "]";
	}

	
	
 
}
