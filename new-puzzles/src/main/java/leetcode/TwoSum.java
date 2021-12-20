package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int [] getSumIndex(int [] arr,int target) {
        int [] sumIndex = null;
        Map<Integer, Integer> mapper = new HashMap<>();

        if (arr != null && arr.length > 0) {

            for (int i = 0 ; i < arr.length; i++){

                int compliment = target - arr[i]; // create the compliment

                if (mapper.containsKey(compliment)) { // if the compliment is available, meaning the record was already traversed.

                    return new int[] {mapper.get(compliment),i};

                } else {
                    mapper.put(arr[i], i); //else put the value in the map and in sometime you might get someone asking for this value as the compliment.
                }

            }
        }

        return sumIndex;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4,5};
        int target = 9;

        int [] sumIndex = getSumIndex (arr, target);
        System.out.println(Arrays.toString(sumIndex));
    }
}
