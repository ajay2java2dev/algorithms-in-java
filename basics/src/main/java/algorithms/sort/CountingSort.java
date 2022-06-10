package algorithms.sort;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountingSort {

    //struct
    static class MinMaxPair {
        int min, max;
        MinMaxPair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    //step 1. find min and max
    static MinMaxPair findMinAndMax (int [] inputArray) {
        return new MinMaxPair(Arrays.stream(inputArray).min().orElse(0),
                Arrays.stream(inputArray).max().orElse(0));
    }

    static void sort (int [] inputArray) {
        MinMaxPair minMaxPair = findMinAndMax(inputArray);
        int [] counterArray = new int [minMaxPair.max - minMaxPair.min + 1];

        //now the new counterArray is ready, start counting
        for (int val: inputArray) {
            //no if and else --> direct formula to decide the index position
            counterArray[val - minMaxPair.min]++; //wow this is nice, not done this before
        }

        //another for loop now to use the counterArray to position the values
        int arrayIndex = 0;
        for (int i =0; i < counterArray.length; i++) {
            while(counterArray[i] > 0) {
                inputArray[arrayIndex] = i + minMaxPair.min;
                counterArray[i]--;
                arrayIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,2,7,4,-2,2};
        System.out.println("Before : " + Arrays.toString(arr));
        long startTime = System.nanoTime();
        sort(arr);
        System.out.println("After : " + Arrays.toString(arr) + ", time taken : " + (System.nanoTime() - startTime));
    }
}
