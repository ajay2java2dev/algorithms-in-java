package org.sample.algorithms.search;

import java.util.Arrays;
import java.util.List;

public class BinarySearchBetterVersion implements BinarySearch {

  @Override
  public long search(List<? extends Number> sortedList, long searchKey) {
    if (sortedList != null && !sortedList.isEmpty()) {
      int lo = 0, hi = sortedList.size() - 1;
      while (lo <= hi) {
        int mid = (lo + (hi - lo) / 2);
        long midVal = (Long) sortedList.get(mid);
        if (midVal == searchKey) {
          return mid;
        } else {
          if (searchKey < midVal) {
            hi = mid - 1;
          } else {
            lo = mid + 1;
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    List<Long> binArray = Arrays.asList(1L, 2L, 20L, 30L, 34L, 45L, 46L);
    BinarySearch binarySearch = new BinarySearchBetterVersion();
    System.out.println(
        "BinarySearchBetterVersion.main --> index found ? : "
		        + binarySearch.search(binArray, 45));

	  System.out.println(
			  "BinarySearchBetterVersion.main --> index found ? : "
					  + binarySearch.search(binArray, 20));


	  System.out.println(
			  "BinarySearchBetterVersion.main --> index found ? : "
					  + binarySearch.search(binArray, -2));
  }
}
