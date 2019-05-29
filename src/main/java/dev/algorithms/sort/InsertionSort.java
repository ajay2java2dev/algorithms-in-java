package dev.algorithms.sort;

/*
	https://www.geeksforgeeks.org/insertion-sort/
	Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
	Since the sorting still has 2 for loops, the chance that all the elements are in descending
	order and hence all the elements need to rearranged will result in Time Complexity of O(n ^ 2)
*/

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

  public void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] a = {0, -1, -2, -4, 1};
    InsertionSort is = new InsertionSort();
    is.sort(a);
    is.printArray(a);
  }
}
