package org.om.aec.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceUseCases
{
	public static void main(String[] args) 
	{
		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		
		ExecutorCompletionService<CompletionResult> completionService = 
				new ExecutorCompletionService<CompletionResult>(threadPool);
		
		completionService.submit(new SyncDataTask());
		completionService.submit(new DownloadTask());
		
		for(int i = 0; i < 2; i++)
		{
			try 
			{
				Future<CompletionResult> take = completionService.take();
				System.out.println(take.get());
			} 
			catch (ExecutionException | InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

class SyncDataTask implements Callable<CompletionResult>
{
	@Override
	public CompletionResult call() throws InterruptedException
	{
		Thread.sleep(500);
		return new CompletionResult("SyncDataTask", true, 500);
	}
}

class DownloadTask implements Callable<CompletionResult>
{
	@Override
	public CompletionResult call() throws InterruptedException
	{
		Thread.sleep(5000);
		return new CompletionResult("DownloadTask", true, 5000);
	}
}

class CompletionResult
{
	private String taskName;
	private boolean isComplted;
	private long timeTakenInMillis;

	CompletionResult(String taskName, boolean isComplted, long timeTakenInMillis)
	{
		this.taskName = taskName;
		this.isComplted = isComplted;
		this.timeTakenInMillis = timeTakenInMillis;
	}

	@Override
	public String toString() {
		return "CompletionResult [taskName=" + taskName + ", isComplted="
				+ isComplted + ", timeTakenInMillis=" + timeTakenInMillis + "]";
	}

}

