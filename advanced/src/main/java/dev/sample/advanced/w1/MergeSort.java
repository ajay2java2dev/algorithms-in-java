package dev.sample.advanced.w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {

  public static void merge (int [] inputArray, int leftIndex, int middleIndex, int rightIndex) {

      //step1: measure the length required to create sub arrays
      int subArray_1_Length = (middleIndex - leftIndex + 1);
      int subArray_2_Length = (rightIndex - middleIndex);

      //step 2: initialize 2 arrays from above
      int [] leftSubArray  = new int[subArray_1_Length];
      int [] rightSubArray = new int[subArray_2_Length];

      //step 3: start Copying data from the inputArray to these new subArrays
      for (int i = 0 ; i < subArray_1_Length; i++) {
        leftSubArray[i] = inputArray [leftIndex + i];
      }
      for (int i = 0; i < subArray_2_Length; i++) {
        rightSubArray[i] = inputArray [middleIndex + 1 + i];
      }

      //step 4: once above sub arrays are ready and has data from input array,
      // start merging them together, but while merging compare the values and insert the lowest amongst them
      int startIndex_1 = 0, startIndex_2 = 0, startIndexOfMergedSubArray = leftIndex;

      while (startIndex_1 < subArray_1_Length && startIndex_2 < subArray_2_Length) {

        if (leftSubArray[startIndex_1] <= rightSubArray[startIndex_2]) {
          inputArray[startIndexOfMergedSubArray] = leftSubArray[startIndex_1];
          startIndex_1++;
        } else {
          inputArray[startIndexOfMergedSubArray] = rightSubArray[startIndex_2];
          startIndex_2++;
        }
        startIndexOfMergedSubArray++;
      }

      //Step 5: now above may not have merged all the entries so we have to merge remaining if there are any remaining values
      //in the two subarrays
      //Also, startIndexOfMergedSubArray will now be having latest index position after above iteration
      while (startIndex_1 < subArray_1_Length) {
        inputArray[startIndexOfMergedSubArray] = leftSubArray [startIndex_1];
        startIndex_1++;
        startIndexOfMergedSubArray++;
      }
      while (startIndex_2 < subArray_2_Length) {
        inputArray[startIndexOfMergedSubArray] = rightSubArray [startIndex_2];
        startIndex_2++;
        startIndexOfMergedSubArray++;
      }
  }

  public static void sort (int [] inputArray, int leftIndex, int rightIndex) {
    //till left is less than right we can keep calling this function recursively
    //BASE CONDITION: (leftIndex should not be greater than rightIndex) will be called and method returns
    if (leftIndex < rightIndex) {
      int middleIndex = (leftIndex + rightIndex) / 2;

      //DIVIDE: sort first half and then second half by recursively calling the same function

      sort (inputArray, leftIndex, middleIndex);
      sort (inputArray, middleIndex + 1, rightIndex);

      //CONQUER: for every recursive call, merge them and keep merging till recursive calls are over
      merge(inputArray, leftIndex, middleIndex, rightIndex);
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

  public static void main(String[] args) {

    System.out.println("-------------------MERGE SORT-------------------");
    System.out.println("-------------------100 Elements (Ascending, Descending, Random)-------------------");
    // Test case 1
    int [] inputArray = generateValuesForArray(100, 1);
    long startTime = System.nanoTime();
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 1 (asc) runtime: " + (System.nanoTime() - startTime) + " ns");
    //displayElements(inputArray);


    // Test case 2
    inputArray = generateValuesForArray(100, -1);
    startTime = System.nanoTime(); //resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 2 (desc) runtime: " + (System.nanoTime() - startTime) + " ns");
    //displayElements(inputArray);


    // Test case 3
    inputArray = generateValuesForArray(100, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 3 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);


    System.out.println("-------------------1000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 4
    inputArray = generateValuesForArray(1000, 1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 4 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 5
    inputArray = generateValuesForArray(1000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 5 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 6
    inputArray = generateValuesForArray(1000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 6 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);


    System.out.println("-------------------10000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 7
    inputArray = generateValuesForArray(10000, 1);
    startTime = System.nanoTime();
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 7 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 8
    inputArray = generateValuesForArray(10000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 8 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 9
    inputArray = generateValuesForArray(10000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 9 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    System.out.println("-------------------100000 Elements (Ascending, Descending, Random)-------------------");
    // Test case 10
    inputArray = generateValuesForArray(100000, 1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 10 (asc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 11
    inputArray = generateValuesForArray(100000, -1);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 11 (desc) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);

    // Test case 12
    inputArray = generateValuesForArray(100000, 0);
    startTime = System.nanoTime();//resetting clock
    sort(inputArray, 0, inputArray.length - 1);
    sort(inputArray, 0, inputArray.length - 1);
    System.out.println("Test case 12 (random) runtime: " + (System.nanoTime() - startTime)+ " ns");
    //displayElements(inputArray);
  }
}
