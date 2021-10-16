package algorithms.sort;

// Merge sort is a divide and conquer algorithm that was invented by John von Neumann in 1945
// Yikes ... somebody knew this in 1945 and I am still rewriting the same thing.
// Interesting fact about divide and conquer, right is always greater than left.
import java.util.Arrays;

public class MergeSort {

  public void merge(int[] arr, int leftIndex, int middleIndex, int rightIndex) {

    int n1 = middleIndex - leftIndex + 1;
    int n2 = rightIndex - middleIndex;

    int tmpLeft[] = new int[n1];
    int tmpRight[] = new int[n2];

    /*Copy data to temp arrays*/

    for (int i = 0; i < n1; ++i) {
      tmpLeft[i] = arr[leftIndex + i];
    }
    for (int j = 0; j < n2; ++j) {
      tmpRight[j] = arr[middleIndex + 1 + j];
    }

    // alternate to above. just to reduce the clutter.
    //tmpLeft = Arrays.copyOfRange(arr, leftIndex, n1);
    //tmpRight = Arrays.copyOfRange(arr, middleIndex, n2);

    // now the real merge.
    int i = 0, j = 0;
    int k = leftIndex; // start index position

    while (i < n1 && j < n2) {

      if (tmpLeft[i] <= tmpRight[j]) {
        arr[k] = tmpLeft[i];
        i++;
      } else {
        arr[k] = tmpRight[j];
        j++;
      }

      k++;
    }

    // now since we have i or j reaching n1 or n2, we would have to copy rest of elements to array.
    while (i < n1) {
      arr[k] = tmpLeft[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = tmpRight[j];
      j++;
      k++;
    }
  }

  public void sort(int[] arr, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      int middleIndex = (leftIndex + rightIndex) / 2;

      sort(arr, leftIndex, middleIndex); // split left and keep on splitting
      sort(arr, middleIndex + 1, rightIndex); // split right and keep on splitting
      merge(arr, leftIndex, middleIndex, rightIndex);
    }
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int[] a = {0, -1, -2, -4, 1};
    ms.sort(a, 0, a.length - 1);
    ms.printArray(a);
  }
}
