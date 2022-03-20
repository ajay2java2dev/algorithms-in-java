package algorithms.util;

import java.util.*;

public class GenerateArrays {

    /*
        order = -1: Descending Order, order = 1: Ascending Order, order = 0: Shuffled Order
        maxBound = greater than the length required. maxBound <= length
     */
    public static int [] getArrayBySortOrder (int length, byte order, int maxBound) {

        if (order < -1 || order > 1)
            throw new IllegalArgumentException("Invalid Parameter - Order: " + order);
        if (length > maxBound)
            throw new IllegalArgumentException("Invalid length size. Maxbound < length");

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
}
