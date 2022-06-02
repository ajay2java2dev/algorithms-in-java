package udemy.master_coding_interview;

import org.junit.jupiter.api.Assertions;

public class RainwaterContainer {

    //looks like leetcode din't like this approach.
    //https://leetcode.com/submissions/detail/712125470/
    static int computeTotalRainwaterBrute (int [] heights) {
        int total = 0;

        for (int i = 1; i < heights.length; i++) {
            int current_pos = i;
            int left_pos = i;
            int right_pos = i;
            int maxLeft = 0, maxRight = 0;

            while (left_pos > 0) {
                left_pos--;
                //using math.max instead.
                maxLeft = Math.max(maxLeft, heights[left_pos]);
            }

            while (right_pos < heights.length) {
                //using math.max instead.
                maxRight = Math.max(maxRight, heights[right_pos]);
                right_pos++;

            }

            if (maxLeft < 0 || maxRight < 0) {
                continue;
            }

            int currentWater = Math.min(maxLeft, maxRight) - heights[current_pos];
            if (currentWater>0) {
                total += currentWater;
            }
        }

        return total;
    }

    // so rather than having single pointer going outwards, have multiple pointers going inwards
    static int computeTotalRainWaterEfficiently (int [] heights) {

        int total = 0;
        int maxLeft = 0, maxRight = 0;
        int left_pos = 0, right_pos = heights.length-1;

        //below logic is bit tough to understand without a sample
        while (left_pos < right_pos) {

            if (heights[left_pos] <= heights[right_pos]) {
                //move left pointer to operate to operate this side
                if (heights[left_pos] >= maxLeft) {
                    maxLeft = heights[left_pos];
                } else {
                    total += maxLeft - heights[left_pos];
                }
                left_pos++;
            } else {
                //move right pointer to left to operate this side
                if (heights[right_pos] >= maxRight) {
                    maxRight = heights[right_pos];
                } else {
                    total += maxRight - heights[right_pos];
                }
                right_pos--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int [] arr = {0, 1, 0, 2, 1, 0, 3 ,1 ,0, 1, 2};
        Assertions.assertEquals(8,computeTotalRainwaterBrute(arr));
        Assertions.assertEquals(8,computeTotalRainWaterEfficiently(arr));

        int [] arr2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assertions.assertEquals(6,computeTotalRainwaterBrute(arr2));
        Assertions.assertEquals(6,computeTotalRainWaterEfficiently(arr2));
    }
}
