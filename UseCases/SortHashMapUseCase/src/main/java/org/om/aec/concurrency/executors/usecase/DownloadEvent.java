package org.om.aec.concurrency.executors.usecase;

class DownloadEvent
{
	private final int eventId;
	private final String message;
	private final boolean isCompleted;

	DownloadEvent(int eventId, boolean isCompleted, String message)
	{
		this.eventId = eventId;
		this.isCompleted = isCompleted;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public int getEventId() {
		return eventId;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	@Override
	public String toString() {
		return "DownloadEvent [eventId=" + eventId + ", message=" + message
				+ ", isCompleted=" + isCompleted + "]";
	}
	
}
