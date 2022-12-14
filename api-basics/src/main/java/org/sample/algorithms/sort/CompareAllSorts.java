package org.sample.algorithms.sort;

import java.util.Arrays;

public class CompareAllSorts {

    static void swap(int [] input, int sourceIndex, int destIndex) {
        int tmp = input[sourceIndex];
        input[sourceIndex] = input[destIndex];
        input[destIndex] = tmp;
    }

    static void bubbleSort(int [] input) {
        for (int i = 0 ; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j+1]) {
                    //swap
                    swap(input, j, j+1);
                }
            }
        }
    }

    static void selectionSort(int [] input) {
        for (int i = 0 ; i < input.length -1 ; i++) {
            int smallerIndex = i; //assume our first index is smaller
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[smallerIndex]) {
                    smallerIndex = j;
                }
            }

            //once the smallest in above iteration
            swap(input, i, smallerIndex);
        }
    }

    //sorted part, and unsorted part managed using two different pointers
    static void insertionSort(int [] input) {
        for (int i = 1 ; i < input.length -1 ; i++) {

            int current = input [i]; //at 0th iteration we set the current value from 1st index
            int j = i - 1; // moves back to jth position
            while (j >= 0 && current < input[j]) {
                input [j + 1] = input [j];
                j--;
            }

            //hold on. before continuing do something about current element
            input[j+1] = current;

        }
    }

    //conquer (see divide first below)
    static void conquer (int [] arr, int start, int mid, int end) {
        int [] merged = new int [end - start + 1];

        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        //simple copy paste
        while (idx1 <= mid ) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= end ) {
            merged[x++] = arr[idx2++];
        }

        //copy merged back to original
        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    //divide
    static void divide (int [] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        //recursively call this again
        divide (arr, start, mid);
        divide (arr, mid + 1, end);

        //try conquer
        conquer (arr, start, mid, end);
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int [] arr = {4,3,2,1};

        System.out.println("\n\nHello, Executing bubble sort!");
        bubbleSort(arr);
        Arrays.stream(arr).forEach(out -> System.out.println("\n" + out));

        System.out.println("\n\nHello, Selection Sort!");
        selectionSort(arr);
        Arrays.stream(arr).forEach(out -> System.out.println("\n" + out));

        System.out.println("\n\nHello, Insertion Sort!");
        insertionSort(arr);
        Arrays.stream(arr).forEach(out -> System.out.println("\n" + out));


        int [] arr1 = {4,3,2,1};

        System.out.println("\n\nHello, Merge Sort!");
        divide(arr1, 0 , arr1.length - 1);
        Arrays.stream(arr1).forEach(out -> System.out.println("\n" + out));
    }
}
