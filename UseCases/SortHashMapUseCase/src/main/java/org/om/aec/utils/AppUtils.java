package org.om.aec.utils;

public class AppUtils 
{
	private AppUtils(){}
	
	public static void printArray(int[] input)
	{
		for (int value : input) 
		{
			System.out.println(value);
		}
	}
	
	public static void asleep(long millis)
	{
		try 
		{
			Thread.sleep(millis);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
