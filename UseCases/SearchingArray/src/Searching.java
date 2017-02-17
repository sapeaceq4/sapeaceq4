
public class Searching {

	public static void main(String[] args) {
		
		int[] unsortedArray={2,8,1,9,7,3,4,6,5};
		
		int largest=unsortedArray[0];
		int second=unsortedArray[0];
		
		for(int i=1;i<unsortedArray.length;i++)
		{
			if(unsortedArray[i]>largest)
			{
				second=largest;
				largest=unsortedArray[i];
			}
			else if(unsortedArray[i]>second && unsortedArray[i]!=largest)
			{
				second=unsortedArray[i];
			}
		}
		
		System.out.println("Largest Element is " + largest);
		System.out.println("Second Largest Element is " + second);
		
		
		
	}
	
}
