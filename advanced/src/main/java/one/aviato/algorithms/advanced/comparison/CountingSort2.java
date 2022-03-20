package one.aviato.algorithms.advanced.comparison;

import java.util.*;

//sorting technique based on keys between specific range.
public class CountingSort {

    static void sort(int array[], int size) {

        int[] output = new int[size + 1];
        int max = size;

        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            count[array[i]] = count[array[i]] + 1;
        }
        //count[i] now contains the number of elements equal to i


        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        //count[i] now contains the number of elements less than or equal to i


        //starting to rotate clockwise
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        //copy back to main array and replace all elements
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
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

        System.out.println("\n---------------COUNTING SORT - INCREASING ORDER ------------------\n");

        int [] array1000 = generateRandomValues(1000, 1000, 1);
        System.out.println("Input : ");
        displayValues(array1000);

        long startTime = System.nanoTime();
        sort(array1000, array1000.length);
        long finishTime = System.nanoTime();

        System.out.println("Output : ");
        displayValues(array1000);

        System.out.println("Time taken: " + (finishTime - startTime));

        System.out.println("\n---------------------------------\n");




        System.out.println("\n---------------COUNTING SORT - DECREASING ORDER ------------------\n");

        array1000 = generateRandomValues(1000, 1000, -1);
        System.out.println("Input : ");
        displayValues(array1000);

        startTime = System.nanoTime();
        sort(array1000, array1000.length);
        finishTime = System.nanoTime();

        System.out.println("Output : ");
        displayValues(array1000);

        System.out.println("Time taken: " + (finishTime - startTime));

        System.out.println("\n---------------------------------\n");




        System.out.println("\n---------------COUNTING SORT - RANDOM ORDER ------------------\n");

        array1000 = generateRandomValues(1000, 1000, 0);
        System.out.println("Input : ");
        displayValues(array1000);

        startTime = System.nanoTime();
        sort(array1000, array1000.length);
        finishTime = System.nanoTime();

        System.out.println("Output : ");
        displayValues(array1000);

        System.out.println("Time taken: " + (finishTime - startTime));

        System.out.println("\n---------------------------------\n");


    }
}
