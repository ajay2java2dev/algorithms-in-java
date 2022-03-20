package one.aviato.algorithms.advanced.sort;

import java.util.*;

public class RandomizedQuickSort_Worst {

    //RANDOM CASE
    public static void RANDOM (int [] arr, int low, int high) {
        int randomPivotIndex = new Random().nextInt(high - low) + low;
        //swap pivot value
        int tmp = arr[randomPivotIndex];
        arr[randomPivotIndex] = arr[high];
        arr[high] = tmp;
    }

    public static int PARTITION (int [] arr, int low, int high) {
        RANDOM(arr, low, high);
        int currentPivotValue = arr[high];
        int smallerIndexPosition = low  - 1;
        for (int j = low; j < high; j++) {

            if (arr[j] < currentPivotValue) {
                smallerIndexPosition++;
                //swap current pivot value with value at index j
                int tmp = arr[smallerIndexPosition];
                arr[smallerIndexPosition] = arr[j];
                arr[j] = tmp;
            }

        }

        int temp = arr[smallerIndexPosition+1];
        arr[smallerIndexPosition+1] = arr[high];
        arr[high] = temp;
        return smallerIndexPosition + 1;
    }

    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = PARTITION(arr, low, high);
            // sort recursively
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    //This is a utility method to generate unique random values
    public static int [] generateRandomValues (int size, int maxRange, int sort) {
        int [] randomArray = new int[size];
        if (size > 0 && maxRange > 0) {
            if (size > maxRange)
                maxRange = size + 100;
            Set<Integer> integerSet = new HashSet<>();
            while (integerSet.size() < size) {
                int randomValue = new Random().nextInt(maxRange);
                integerSet.add(randomValue);
            }
            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(integerSet);
            if (sort == -1)
                Collections.reverse(integerList);
            else if (sort == 0)
                Collections.shuffle(integerList);
            randomArray = integerList.stream().mapToInt(Integer::intValue).toArray();
        }
        return randomArray;
    }

    public static void displayValues (int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        System.out.println("\n---------------------------------\n");

        int [] array100 = generateRandomValues(100, 200, -1);
        System.out.println("RANDOM PIVOTING: Testing 100 Random started. Input: ");
        displayValues(array100);
        long startTime = System.nanoTime();
        sort(array100, 0 , array100.length -1);
        long finishTime = System.nanoTime();
        System.out.println("RANDOM PIVOTING: Testing 100 Random finished. Results: ");
        displayValues(array100);
        System.out.println("RANDOM PIVOTING: 100 Records Time taken: " + (finishTime - startTime));

        System.out.println("\n---------------------------------\n");

        array100 = generateRandomValues(100, 200, 0);
        System.out.println("RANDOM SORTING (PIVOT = MIDDLE): Testing 100 Descending started. Input: ");
        displayValues(array100);
        startTime = System.nanoTime();
        sort(array100, 0 , array100.length -1);
        finishTime = System.nanoTime();
        System.out.println("RANDOM SORTING (PIVOT = MIDDLE): Testing 100 Descending finished. Results: ");
        displayValues(array100);
        System.out.println("RANDOM SORTING (PIVOT = MIDDLE): 100 Records Time taken: " + (finishTime - startTime));

        System.out.println("\n---------------------------------\n");
    }
}
