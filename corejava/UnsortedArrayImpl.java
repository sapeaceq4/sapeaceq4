package com.sapient.usecases.corejava;

import java.util.Scanner;

public class UnsortedArrayImpl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size : ");
		int n = sc.nextInt();

		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter value for array : ");
			a[i] = sc.nextInt();
		}
		System.out.print("Enter k : ");
		int k = sc.nextInt();

		int l=0,u=n-1,i,j,x;
		while(l<u)
		{
			i=l;
			j=u;
			x=a[k];

			while(i<=k && j>=k)
			{
				while (a[i]<x)
					i++;
				while (a[j]>x)
					j--;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			}
			if (j<k)
				l=i;
			if (i>k)
				u=j;
		}

		System.out.println("kth Smallest element : "+a[k]);
		sc.close();
	}
}

