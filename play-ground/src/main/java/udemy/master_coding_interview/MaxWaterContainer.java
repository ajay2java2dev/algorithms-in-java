package udemy.master_coding_interview;

import java.util.List;

public class MaxWaterContainer {

    static class Pair<S, T, V> {
        S source;
        T target;
        V value;

        public Pair(S source, T target, V value) {
            this.source = source;
            this.target = target;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "source=" + source +
                    ", target=" + target +
                    ", value=" + value +
                    '}';
        }
    }

    static Pair<Integer, Integer, Integer> getMaxWaterContainerBrute (int [] heights) {
        int maxArea = 0;
        Pair maxPair = null;

        for (int i = 0 ; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int minHeight = Math.min(heights[i], heights[j]);
                int distance = j - i;
                int area = minHeight * distance;
                if (maxArea < area) {
                    maxArea = area;
                    maxPair = new Pair(i, j, maxArea);
                }
            }
        }
        return maxPair;
    }

    static Pair<Integer, Integer, Integer> getMaxWaterContainerEfficient (int [] heights) {
        int p1 = 0, p2 = heights.length - 1, maxArea = 0;
        Pair<Integer, Integer, Integer> pair = null;
        while (p1 < p2) {
            int minHeight = Math.min(heights[p1], heights[p2]);
            int distance = p2 - p1;
            int area = minHeight * distance;

            if (maxArea < area) {
                maxArea = area;
                pair = new Pair<Integer, Integer, Integer>(p1, p2, maxArea);
            }

            if (heights[p1] < heights[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int [] heights = {1,8,6,2,9,4};
        long startTime = System.nanoTime();
        System.out.println("Max water pair: " + getMaxWaterContainerBrute(heights) + " , time_taken: " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        System.out.println("Max water pair: " + getMaxWaterContainerEfficient(heights) + " , time taken: " + (System.nanoTime() - startTime));
    }
}
