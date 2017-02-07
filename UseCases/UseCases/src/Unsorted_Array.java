import java.util.Arrays;
import java.util.Scanner;


public class Unsorted_Array {
	public static void main(String[] args) {
		int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
     // reverse the array
     for(int i=0;i<arr.length/2;i++) {
          // swap the elements
          int temp = arr[i];
          arr[i] = arr[arr.length-(i+1)];
          arr[arr.length-(i+1)] = temp;
     }
     
     System.out.println("The largest element is :-" + arr[0]);
     System.out.println("The second largest element is :-" + arr[1]);
    }
}
