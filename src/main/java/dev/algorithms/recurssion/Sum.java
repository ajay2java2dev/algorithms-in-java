package dev.algorithms.recurssion;

public class Sum {

  public static int calculateSum(int n) {

  	if (n == 1) {
      return 1;
    }

    int sum = n + calculateSum(n - 1);
  	if (sum>5 && sum <7) {
  	  return 0;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(calculateSum(5));
  }
}
