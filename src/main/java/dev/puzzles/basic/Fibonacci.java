package dev.puzzles.basic;

public class Fibonacci {

  int iterationCount = 0;

  public int calculate(int n, String frm) {
    if (iterationCount == 0) {
      System.out.println("Starting iterations...");
    }

    iterationCount++;
    System.out.println("N val : " + n + " , iteration count : " + iterationCount + " , for level :" + frm);

    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    }

    return calculate(n - 1, "level 1") + calculate(n - 2, "level 2");
  }

  public static void main(String[] args) {

    Fibonacci fibonacci = new Fibonacci();
    System.out.println("Fibonacci.main .. fib val : " + fibonacci.calculate(10, "base"));
  }
}
