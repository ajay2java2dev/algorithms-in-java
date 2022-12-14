package org.sample.algorithms.sort;

/*
	https://www.geeksforgeeks.org/insertion-sort/
	Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
	Since the sorting still has 2 for loops, the chance that all the elements are in descending
	order and hence all the elements need to rearranged will result in Time Complexity of O(n ^ 2)
*/

import java.util.Arrays;

public class InsertionSort {

  // iterate multiple times and insert the least element to the front.
  public void sort(int[] arr) {

    if (arr.length > 0) {

      for (int i = 1; i < arr.length; i++) {

        int keyVal = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > keyVal) {
          arr[j + 1] = arr[j];
          j = j - 1; //last iteration always makes j = j - 1, in the outside of loop make j = j + 1
        }

        arr[j + 1] = keyVal;
      }
    }
  }

  public void simpleInsertionSort_1 (Integer [] arr) {
    if (arr.length > 0 ) {
      for ( int i = 1 ; i < arr.length ; i ++) {
        for (int j = i ; j > 0 ; j --) {
          //dont have to adjust iteration above to scan all elements
          if (arr[j-1].compareTo(arr[j]) > 0) {
            Integer val = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = val;
          } else {
            break;
          }
        }
      }
    }
  }

  //https://www.geeksforgeeks.org/binary-insertion-sort/
  public void binarySort(int array[])
  {
    for (int i = 1; i < array.length; i++)
    {
      int x = array[i];

      // Find location to insert using binary search
      int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

      //Shifting array to one location right
      System.arraycopy(array, j, array, j+1, i-j);

      //Placing element at its correct location
      array[j] = x;
    }
  }

  public void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    int[] a = {0, -1, -2, -4, 1};
    insertionSort.sort(a);
    insertionSort.printArray(a);

    int[] a1 = {0, -1, -2, -4, 1};
    insertionSort.binarySort(a1);
    insertionSort.printArray(a1);

    int[] a2 = {0, -1, -2, -4, 1};
    Integer [] arr = Arrays.stream(a2).boxed().toArray(Integer[]::new);
    insertionSort.simpleInsertionSort_1(arr);
    Arrays.stream(arr).forEach(System.out::println);
  }
}
