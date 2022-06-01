package udemy.master_coding_interview;

public class RainwaterContainer {

    //looks like leetcode din't like this approach.
    //https://leetcode.com/submissions/detail/712125470/
    static int computeTotalRainwaterBrute (int [] heights) {
        int total = 0;

        for (int i = 1; i < heights.length; i++) {
            int current_pos = i;
            int left_pos = i;
            int right_pos = i;
            int maxLeft = -1, maxRight = -1;

            while (left_pos > 0) {
                left_pos--;
                if (maxLeft < heights[left_pos]) {
                    maxLeft = heights[left_pos];
                }
            }

            while (right_pos < heights.length) {
                if (maxRight < heights[right_pos]) {
                    maxRight = heights[right_pos];
                }
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

    public static void main(String[] args) {
        int [] arr = {0, 1, 0, 2, 1, 0, 3 ,1 ,0, 1, 2};
        System.out.println(computeTotalRainwater(arr));
    }
}
