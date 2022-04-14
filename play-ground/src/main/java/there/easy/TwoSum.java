package there.easy;

/*
 Problem : Given an array find if there are elements in the array which can
 lead to a sum.
   1) Task 1: First check if there are any 2 elements in the array which can
    lead to the given target value.
   2) Task 2: Check if there can be combinations of the elements which can
   lead to the given target value.
*/

/*
 This problem I came across through a google video.
 The solution would look simple once you look at it but
 this problem is a good candidate for showcasing edge cases and
 how to go about resolving it step-by-step.

 - Youtube Google Intro: https://www.youtube.com/watch?v=XKu_SEDAykw
 - Play Store AppsD&S (jaypee): https://play.google.com/store/apps/details?id=com.jaypeesoft.ds
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  // enova 1: 2 index approach
  public int[] findTwoIndex(int[] originalArray, int target) {

  	boolean isExists = false;
    int[] returnArr = new int[2];
    Map<Integer, Integer> complimentTable = new HashMap<Integer, Integer>();

    for (int i = 0; i < originalArray.length; i++) {

      Integer val = complimentTable.get(target - originalArray[i]);
      if (val == null) {
        complimentTable.put(originalArray[i], i);
      } else {
        returnArr[0] = val;
        returnArr[1] = i;
        isExists = true;
        break;
      }
    }

    return isExists?returnArr:null;
  }

  //enova 2: The google solution: https://www.youtube.com/watch?v=XKu_SEDAykw

  // enova 3: To find all the index positions which could have resulted in the correct answer.
  public int[] findIndexPostions(int[] originalArray, int target) {
    int[] returnArr = new int[originalArray.length];
    //TODO: This is bit complicated so left for tonight - 05/04/2019
    return returnArr;
  }


  public static void main(String[] args) {
    TwoSum sum = new TwoSum();

    int[] arr1 = {-1, 2, 4, 9};
    int target1 = 8;
    int[] returnVals1 = sum.findTwoIndex(arr1, target1);
    System.out.println(
        (returnVals1 != null && returnVals1.length > 0) ? "Exists" : "Not Exists");

    int[] arr2 = {-1, 2, 4, 9};
    int target2 = 5;
    int[] returnVals2 = sum.findTwoIndex(arr2, target2);
    System.out.println(
        (returnVals2 != null && returnVals2.length > 0) ? "Exists" : "Not Exists");

    int[] arr3 = {-1, 2, 4, 9};
    int target3 = 9;
    int[] returnVals3 = sum.findTwoIndex(arr3, target3);
    System.out.println(
        (returnVals3 != null && returnVals3.length > 0) ? "Exists" : "Not Exists");
  }
}
