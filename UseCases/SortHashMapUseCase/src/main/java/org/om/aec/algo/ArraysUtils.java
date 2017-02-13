package org.om.aec.algo;

public class ArraysUtils 
{
	private ArraysUtils(){}
	
	public static void printLargestAndSecondLargestElement(int[] input)
	{
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int value: input) 
		{
			if(value > firstLargest)
			{
				secondLargest = firstLargest;
				firstLargest = value;
			}
		}
		
		System.out.println("firstLargest="+ firstLargest + " ,secondLargest="+secondLargest);
	}
}
