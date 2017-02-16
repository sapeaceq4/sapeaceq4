package com.sapient.ace.usecases;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class SecondLargestElement {

    private static int[] array = {-35, -5, -86, -89, -79, -346, -934, -6, -45, -8, -70, -456, -68, -568};

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE, _2max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                _2max = max;
                max = array[i];
            } else if (array[i] > _2max) {
                _2max = array[i];
            }
        }
        System.out.println("Maximum element " + max + " Second element " + _2max);
    }
}
