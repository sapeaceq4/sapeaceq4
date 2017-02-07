package com.sapient.ACE.Package;

import javax.print.attribute.ResolutionSyntax;

public class FindLargest {

	static int[] findLarge(int[] ar){
		
		int[] result=new int[2];
		int largest=ar[0];
		int secLargest=ar[1];
		for(int i=1;i<ar.length;i++){
			if(largest<ar[i]){
				secLargest=largest;
				largest=ar[i];
			}
			if(largest>ar[i] && secLargest<ar[i]){
				secLargest=ar[i];
			}
		}
		result[0]=largest;
		result[1]=secLargest;
		return result;
		
	}
	
	
	public static void main(String[] args) {
	
		int[] ar= {54,53,3,7,1,10,24,12,55,6,4};
		
		int[] result=findLarge(ar);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
}
