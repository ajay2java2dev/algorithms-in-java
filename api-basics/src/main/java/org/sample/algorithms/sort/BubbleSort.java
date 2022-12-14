package org.sample.algorithms.sort;

import java.util.Arrays;

public class BubbleSort{

    public void doSort(int [] input) {
        for (int i = 0; i < input.length - 1; i++) {

            for (int j= 0; j < input.length - i -1; j++) {
                if (input[j] > input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }

        }
    }

    public void doSortDiff (int [] input) {
        for (int i = 0 ; i < input.length; i++) {

            for (int j = i + 1; j < input.length -1 ; j++) {
                if (input[j] > input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int [] arr = {7,3,1,2,8};
        BubbleSort sort = new BubbleSort();
        long startTime = System.nanoTime();
        sort.doSort(arr);
        System.out.println("Time taken : " + (System.nanoTime() - startTime));
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("differently ........");

        int [] arr1 = {7,3,1,2,8};
        startTime = System.nanoTime();
        sort.doSortDiff(arr);
        System.out.println("Time taken : " + (System.nanoTime() - startTime));
        Arrays.stream(arr).forEach(System.out::println);
    }

}
