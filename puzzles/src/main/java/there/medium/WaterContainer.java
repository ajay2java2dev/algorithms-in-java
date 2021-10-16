package there.medium;

/*
  Problem: Given a set of heights seperated by units distance, find the max area of a container
  which can hold water. Assume here that heights are the 2 vertical axis and x-axis is the base
  to hold that water.
*/

/*
  Ok so what were my understandings here ?:
  1) When I was looking at the main for and (right -left) it made me wonder whether we will have
  negative values. I was unfortunately thinking about heights and not these being just the index
  positions. So that's good.

  2) This was a clean approach to simply take Math.Min and Math.Max rather than doing multiple if-else
  blocks

 */
public class WaterContainer {

  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0; // this will hold the max area everytime

    // PJ: dont go equals here. you wo
    while (left < right) {

      maxArea = Math.max(maxArea, Math.min(height[left], height[right])) * (right - left);

      System.out.println("enova.maxArea -->> current : " + maxArea);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }

    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] heights = {4, 6, 12, 7, 9, 11, 10};
    WaterContainer solution = new WaterContainer();
    int maxArea = solution.maxArea(heights);
    System.out.println(maxArea);
  }
}
