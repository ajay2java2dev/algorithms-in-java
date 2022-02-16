package dev.sample.advanced.w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

  public static void sort (int [] inpuArray) {

    if (inpuArray != null && inpuArray.length > 1) {

      //index starts from 0 in an array. So here we start with index 1
      for (int index = 1; index < inpuArray.length; index++ ) {

        int currentKey = inpuArray[index]; // get value from array
        int previousIndex = index - 1;

        //move elements in the array ahead of the key
        for (; previousIndex >= 0 && inpuArray[previousIndex] > currentKey; previousIndex--) {
          inpuArray[previousIndex + 1] = inpuArray[previousIndex];
        }

        //finally place the key in the position available.
        inpuArray[previousIndex + 1] = currentKey;
      }
    }
  }

  static int [] generateValuesForArray (int count, int sortType) {
    int [] array = new int[count];

    //elements ascending order
    if (sortType == 1) {
      for (int a = 0; a < array.length; a++) {
        array[a] = (a + 1);
      }
    } else if (sortType == -1) {
      //elements descending order
      for (int a = array.length; a > 0; a--) {
        array[array.length - (a)] = (a);
      }
    } else {
      // random order
      List<Integer> integerList = new ArrayList<>(count);
      for (int a = 0; a < array.length; a++) {
        integerList.add((a + 1));
      }
      Collections.shuffle(integerList);
      for (int a = 0; a < integerList.size(); a++) {
        array[a] = integerList.get(a);
      }
    }
    return array;
  }

  static void displayElements(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(" "+ arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) throws InterruptedException {

    System.out.println("-------------------INSERTION SORT-------------------");
    System.out.println("-------------------100 Elements (Ascending, Descending, Random)-------------------");
    // Test case 1
    int [] inputArray = generateValuesForArray(100, 1);
    long startTime = System.nanoTime();
    sort(inputArray);
    System.out.println("Test case 1 (asc) runtime: " + (System.nanoTime() - startTime) + " ns");
    //displayElements(inputArray);


    // Test case 2
    inputArray = generateValuesForArray(100, -1);
    startTime = System.nanoTime(); //resetting clock
    sort(inputArray);
    System.out.println("Test case 2 (desc) runtime: " + (System.nanoTime() - startTime) + " ns");
    //displayElements(inputArray);


    // Test case 3
    inputArray = generateValuesForArray(100, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 3 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);


    System.out.println("-------------------1000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 4
    inputArray = generateValuesForArray(1000, 1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 4 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 5
    inputArray = generateValuesForArray(1000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 5 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 6
    inputArray = generateValuesForArray(1000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 6 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);


    System.out.println("-------------------10000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 7
    inputArray = generateValuesForArray(10000, 1);
    startTime = System.nanoTime();
    sort(inputArray);
    System.out.println("Test case 7 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 8
    inputArray = generateValuesForArray(10000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 8 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 9
    inputArray = generateValuesForArray(10000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 9 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    System.out.println("-------------------100000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 10
    inputArray = generateValuesForArray(100000, 1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 10 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 11
    inputArray = generateValuesForArray(100000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 11 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 12
    inputArray = generateValuesForArray(100000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray);
    System.out.println("Test case 12 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);
  }
}
