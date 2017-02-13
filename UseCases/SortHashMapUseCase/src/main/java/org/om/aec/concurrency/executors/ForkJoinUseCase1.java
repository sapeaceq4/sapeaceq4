package org.om.aec.concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinUseCase1
{
	
	static class QSort extends RecursiveAction
	{
		private static final long serialVersionUID = 1L;
		private int[] arr;
		private int startIndex;
		private int endIndex;

		QSort(int[] arr, int startIndex, int endIndex)
		{
			this.arr = arr;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
		
		@Override
		protected void compute() 
		{
			if(startIndex < endIndex)
			{
				int p = partiton(arr, startIndex, endIndex);
				QSort task1 = new QSort(arr, startIndex, p);
				task1.fork();
				QSort task2 = new QSort(arr, p + 1, endIndex);
				task2.fork();
				
				task1.join();
				task2.join();
			}
		}
		
		private int partiton(int[] arr, int startIndex, int endIndex)
		{
			int x = arr[startIndex];
			int i = startIndex - 1;
			int j = endIndex + 1;
			while(true)
			{
				do{
					j--;
				}while(arr[j] >  x);
				
				do{
					i++;
				}while(arr[i] <  x);
				
				if(i < j)
				{
					swap(arr, i, j);
				}
				else
				{
					return j;
				}
			}
		}
		
		private void swap(int[] arr, int from, int to)
		{
			int temp = arr[from];
			arr[from] = arr[to];
			arr[to] = temp;
		}
	}
	
	
	public static void sort(int[] input) throws InterruptedException, ExecutionException
	{
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(new QSort(input, 0, input.length -1)).get();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		int[] input = {3,2,6,7,1,0};
		sort(input);
		for (int element : input) {
			System.out.println(element);
		}
	}
}
