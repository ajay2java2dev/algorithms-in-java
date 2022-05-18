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

    static Map<Integer, Integer> optimalSolution(int [] arr, int target) {
        var indexMap = new HashMap<Integer, Integer>();
        var keyValueMap = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < arr.length; i++) {
            int numToFind = target - arr[i];
            if (keyValueMap.containsKey(numToFind)) {
                indexMap.put(keyValueMap.get(numToFind),i);
            } else {
                keyValueMap.put(arr[i], i);
            }
        }
        return indexMap;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int target = 10;

        System.out.println("*****************************************************************");
        System.out.println("Starting bruteforce ...");
        var startTime = System.nanoTime();
        bruteForceSolution(arr, target).entrySet().forEach(integerIntegerEntry -> {
            System.out.format("\nstart_index: %d, end_index: %d\n",integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
        });
        var bruteTimeTaken = (System.nanoTime() - startTime);
        System.out.println("Time taken (ns): " + (bruteTimeTaken));

        System.out.println("*****************************************************************");
        System.out.println("Starting optimal ...");
        startTime = System.nanoTime();
        optimalSolution(arr, target).entrySet().forEach(integerIntegerEntry -> {
            System.out.format("\nstart_index: %d, end_index: %d\n",integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
        });
        var optTimeTaken = (System.nanoTime() - startTime);
        System.out.println("Time taken (ns): " + optTimeTaken);
        System.out.println("*****************************************************************");
        System.out.println("Total performace improvement with hashmap (in %): " + Float.valueOf(((float) bruteTimeTaken - (float)optTimeTaken)/(float)bruteTimeTaken) * 100);
    }
}
