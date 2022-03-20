package cracking_the_coding_interview.sortingandsearching;

import java.util.*;

/*
11.1 - Given two sorted arrays A and B, where A has large enough buffer to hold B, merge A and B together and maintain sorted order
Solution:
- Basically this is compare sort.
- Only issue with this is that if we insert elements to arr1, then we need to shift the remaining elements backwards.
- Start comparing elements from tail for each element and set them to end of arr1 since there is space in the end of arr1.
- There is not much to learn apart from the fact that you can keep two arrays sorted during the merge process itself instead of
first merging them and then sorting.
*/
public class PG121_11_1_MergeSortedArrays {

    public static void merge (int [] arr1, int [] arr2, int last1, int last2){
        int lastIndex1 = last1 -1; //index of last element in arr1
        int lastIndex2 = last2 -1; //index of last element in arr2
        int indexMerged = last1 + last2 - 1; //end of merged array

        //merge arr1 and arr2, starting from the last element in each
        while (lastIndex1 >= 0 && lastIndex2 >= 0) {
            if (arr1[lastIndex1] > arr2[lastIndex2]) {
                arr1[indexMerged] = arr1[lastIndex1];
                indexMerged--;
                lastIndex1--;
            } else {
                arr1[indexMerged] = arr2[lastIndex2];
                indexMerged--;
                lastIndex2--;
            }
        }

        //copy remaining elements from arr2 to into place
        while(lastIndex2 >= 0) {
            arr1[indexMerged] = arr2[lastIndex2];
            indexMerged--;
            lastIndex2--;
        }
    }

    public static int [] generateRandomArray (int length, byte order, int maxBound) {

        if (order < -1 || order > 1)
            throw new IllegalArgumentException("Invalid Parameter - Order: " + order);

        Set<Integer> uniqueValues = new HashSet<>();
        Random newRandom = new Random();
        while (uniqueValues.size() < length) {
            int randomValue = newRandom.nextInt(maxBound);
            uniqueValues.add(randomValue);
        }

        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(uniqueValues);

        if (order == -1) {
            Collections.sort(integerList, Collections.reverseOrder());
        } else if (order == 1) {
            Collections.sort(integerList);
        } else {
            Collections.shuffle(integerList);
        }

        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void displayElementsInArray (int [] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int [] array1 = generateRandomArray(10, (byte) 1, 100);
        int [] array2 = generateRandomArray(10, (byte) 1, 100);
        displayElementsInArray(array1);
        displayElementsInArray(array2);
        int [] array3 = Arrays.copyOf(array1, array1.length + array2.length);

        merge(array3, array2, array1.length, array2.length);
        displayElementsInArray(array3);
    }
}
