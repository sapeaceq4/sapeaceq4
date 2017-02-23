package com.sapient;

public class Mergesort {
        private int[] numbers;
        private int[] helperArray;

        private int number;

        public void sort(int[] values) {
                this.numbers = values;
                number = values.length;
                this.helperArray = new int[number];
                mergesort(0, number - 1);
        }

        private void mergesort(int low, int high) {
               
                if (low < high) {
                        
                        int middle = low + (high - low) / 2;
                        mergesort(low, middle);
                        mergesort(middle + 1, high);
                        merge(low, middle, high);
                }
        }

        private void merge(int low, int middle, int high) {

                // Copy both parts into the helper array
                for (int i = low; i <= high; i++) {
                	helperArray[i] = numbers[i];
                }

                int i = low;
                int j = middle + 1;
                int k = low;
                // Copy the smallest values from either the left or the right side back
                // to the original array
                while (i <= middle && j <= high) {
                        if (helperArray[i] <= helperArray[j]) {
                                numbers[k] = helperArray[i];
                                i++;
                        } else {
                                numbers[k] = helperArray[j];
                                j++;
                        }
                        k++;
                }
                // Copy the rest of the left side of the array into the target array
                while (i <= middle) {
                        numbers[k] = helperArray[i];
                        k++;
                        i++;
                }

        }
}