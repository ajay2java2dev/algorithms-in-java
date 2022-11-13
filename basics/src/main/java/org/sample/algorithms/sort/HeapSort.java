package org.sample.algorithms.sort;

public class HeapSort {

  static void swap (int [] arr, int from, int to) {
    int tmp = arr[from];
    arr[from] = arr[to];
    arr[to] = tmp;
  }

  static void heapify (int [] arr , int arr_length, int rootIndex) {
    //1. Find largest amongst root, left, child
    int largestIndex = rootIndex; //suppose the rootIndex passed is largest already
    int leftIndex = 2 * rootIndex + 1;
    int rightIndex = 2 * rootIndex + 2;

    if (leftIndex < arr_length && arr[leftIndex] > arr[largestIndex]) {
      largestIndex = leftIndex;
    }

    if (rightIndex < arr_length && arr[rightIndex] > arr[largestIndex]) {
      largestIndex = rightIndex;
    }

    if (largestIndex != rootIndex) {
      swap(arr, largestIndex, rootIndex);
      heapify(arr, arr_length, largestIndex);
    }
  }

  static void sort (int [] arr) {
    if (arr == null)
      return;

    int arr_length = arr.length;
    //1. Build max heap
    for (int i = arr_length/2 - 1; i >=0 ; i--){
      heapify(arr, arr_length, i);
    }

    //2. Heap Sort

  }

  static void display(int [] arr) {
    for (int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + "\t");
    }
  }

  public static void main(String[] args) {
    int [] arr = {1, 10, 12, 2, 4,9 ,13};
    sort(arr);
    display(arr);
  }
}
