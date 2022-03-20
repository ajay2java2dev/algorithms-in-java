package epi;

import java.util.HashSet;
import java.util.Set;

public class PG31_smallest_change {
    public int smallestChange (int [] input) {
        int expected_value = input[0];

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(expected_value);

        for (int i = 0; i < input.length; i++) {
            int sum = input[i];
            for (int j = i + 1; j < input.length; j++) {
                expected_value = expected_value+1;
                sum = sum + input[j];
                integerSet.add(expected_value);
                integerSet.add(sum);
            }
        }


        int sum = input[0];
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                sum = sum + input[j];
                if (!integerSet.contains(sum)){
                    expected_value = sum;
                    break;
                }
            }
        }

        return expected_value;
    }

    public static void main(String[] args) {
        PG31_smallest_change smallest_change = new PG31_smallest_change();
        int [] input = {1,1,1,1,1,5,10,25}; //sorted ???
        System.out.println(smallest_change.smallestChange(input));
    }
}
