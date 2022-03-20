package algorithms.util;

import java.util.*;

public class ValueGenerator {

    public static int [] generateRandomIntValues (int num_of_elements, int bound) {
        int [] arr = new int[num_of_elements];
        Set<Integer> uniqueSet = new HashSet<>();
        int i = 0;
        while (i <= uniqueSet.size()) {
            var intVal = new Random().nextInt(10);
            if (!uniqueSet.contains(intVal)) {
                arr[i] = intVal;
                uniqueSet.add(intVal);
            }
        }
        return arr;
    }

    public static void displayItems(int[] arr) {
        System.out.println("\n---------------------------");
        Arrays.stream(arr).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println("\n---------------------------");
    }
}
