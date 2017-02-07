package sort;

public class largest {

	public static void main(String args[])
	{
		int arr[]={29,45,67,234,975,236,74,234};
		int max=arr[0];
		int secmax= arr[0];
		for(int i =0;i <arr.length; ++i)
		{
			
			if(arr[i]>max)
			{
				secmax=max;
				max=arr[i];
			}
			else if(arr[i] > secmax && arr[i] != max)
			{
				secmax=arr[i];
			}
			
		}
		
		System.out.println("largest no is:" + max);
		System.out.println("2nd largest no is:" + secmax);
		
		
		
		
		
	}
	
	
	
	
}
