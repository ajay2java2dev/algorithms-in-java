package org.sample.algorithms.search;

import java.util.Arrays;

public class BinarySearchJavaUtil {

  public static void main(String[] args) {

    // int a[] = {1, 2, 3, 4, 5, 6, 10, 11, 12};
    int a[] = {-3, -1,1};

    Arrays.sort(a);

    Arrays.stream(a).forEach(System.out::println);

    int firstMinVal = 0;

    for (int i = 0; i < a.length; i++) {

      firstMinVal = a[i] + 1;
      int val = Arrays.binarySearch(a, firstMinVal);

      // if not found ...
      if (val <= 0 && firstMinVal > 0) {
        break;
      }
    }

    if (firstMinVal > 0) {
      System.out.println("Next Min Val " + firstMinVal);
    } else {
      System.out.println("Next Min Val " + 1);
    }
  }
}
