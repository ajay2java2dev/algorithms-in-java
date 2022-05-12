package google;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static Map<Integer,Integer> bruteForceSolution(int [] arr, int target) {
        var indexMap = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < arr.length; i++) {
            int numToFind = target - arr[i];
            for (int j = i + 1 ; j < arr.length; j++) {
                if (arr[j] == numToFind) {
                    indexMap.put(i,j);
                }
            }
        }
        return indexMap;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int target = 10;
        bruteForceSolution(arr, target).entrySet().forEach(integerIntegerEntry -> {
            System.out.format("\nstart_index: %d, end_index: %d\n",integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
        });

    }
}
