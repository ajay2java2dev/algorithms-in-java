package dev.puzzles.google;

/*
https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
Given an array A of N elements. The task is to complete the function which returns true
if triplets exists in array A whose sum is zero else returns false.

MyRating : After seeing the question and the solution, I would give this a medium rating.
*/

import java.util.Arrays;
import java.util.HashSet;

public class FindingTriplets {

  // the natural approach to the problem is to iterate over multiple times till we reach the sol
  // notice the iteration end 1 before previous at each higher level & starts at 1 level ahead
  // at each lower level.
  public boolean approach1(int[] arr) {
    if (arr.length > 0) {
      for (int i = 0; i < arr.length - 2; i++) {
        for (int j = 1; j < arr.length - 1; j++) {
          for (int k = 2; k < arr.length; k++) {
            int sum = arr[i] + arr[j] + arr[k];
            if (sum == 0) {
              // if you want to find all the triplet, then dont return from here.
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  // the second solution would reduce the iteration by using the hash map to store the next value
  // you still have to iterate twice in this approach and the map is for the third iteration only
  public boolean approach2(int[] arr) {
    if (arr.length > 0) {

      HashSet<Integer> keyStorage = new HashSet<>();
      for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 1; j < arr.length; j++) {

          int key = -(arr[i] + arr[j]);

          if (keyStorage.contains(key)) {

            // FIXME :Do i need to check if sum is really zero or not ???
            // if you want to find all the triplet, then dont return from here.
            return true;

          } else {
            keyStorage.add(arr[j]);
          }
        }
      }
    }
    return false;
  }

  // the third solution is to sort them out at first and then iterate only once.
  public boolean approach3(int[] arr) {

    if (arr.length > 0) {
      Arrays.sort(arr);

      for (int i = 0; i < arr.length; i++) {

        int left = i + 1;
        int right = arr.length - 1;

        while (left < right) {

          int sum = arr[i] + arr[left] + arr[right];

          if (sum == 0) {
            // if you want to find all the triplet, then dont return from here.
            return true;
          } else if (sum < 0) {
          	left++;
          } else {
          	right--;
          }
        }

      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] a = {0, -1, -2, -4, 1};
    FindingTriplets ft = new FindingTriplets();
    System.out.println(ft.approach1(a));
    System.out.println(ft.approach2(a));
    System.out.println(ft.approach3(a));
  }
}
