package com.sapient.ace.usecases;

/**
 * Created by Ravdeep Singh on 2/27/2017.
 */
public class FindMissingTwoNumber {

    public static void main(String[] args) {
        int array[]  = {1,2,4,8,7,5};
        int n = 8;
        findTwoMissingNumbers(array, n);
    }

    private static void findTwoMissingNumbers(int[] array, int n) {
        int sum = 0;
        int product = 1;

        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }

        for (int i = 0; i <array.length ; i++) {
            product*=array[i];
        }

        int sumOfN = (n+1)*n/2;
        int productOfN = 1;

        for (int i = 1; i <=n ; i++) {
            productOfN*=i;
        }

        int x,y = 0;

        int sumOfXY = sumOfN-sum;
        int productXY = productOfN /product;


        int a = 1;
        int b = sumOfXY;
        int c = productXY;


        //Finding out the roots
        double temp1 = Math.sqrt(b * b - 4 * a * c);

        double root1 = (-b +  temp1) / (2*a) ;
        double root2 = (-b -  temp1) / (2*a) ;

        System.out.println("X "+(int)Math.abs(root1));
        System.out.println("y "+(int)Math.abs(root2));
    }
}
