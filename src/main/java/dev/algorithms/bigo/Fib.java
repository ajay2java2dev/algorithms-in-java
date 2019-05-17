package dev.algorithms.bigo;

public class Fib {

  public static int badFib(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return badFib(n - 1) + badFib(n - 2);
    }
  }

  // the gayle memonization approach... --> https://vimeo.com/157480836
  // not good enough --> fib (10000) resulted in stackoverflow
  public static int okFib(int n, int[] memo) {
    if (n == 0 || n == 1) {
      return 1;
    } else if (memo[n] == 0) {
      memo[n] = okFib(n - 1, memo) + okFib(n - 2, memo);
    }
    return memo[n];
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    // bad fib is ugly. each level doubles k times (2^k
    System.out.println("fib of 10 (bad fib): " + badFib(10));
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));

    startTime = System.currentTimeMillis();
    // below all will get stuck in bad fib
    System.out.println("fib of 10 : " + okFib(10, new int[10+2])); // why +2 ? for n-1 and n-2
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));

    startTime = System.currentTimeMillis();
    System.out.println("fib of 100 : " + okFib(100, new int[100+2]));
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));

    startTime = System.currentTimeMillis();
    System.out.println("fib of 1000 : " + okFib(1000, new int[1000+2]));
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));

    startTime = System.currentTimeMillis();
    System.out.println("fib of 10000 : " + okFib(10000, new int[10000+2]));
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));

    startTime = System.currentTimeMillis();
    System.out.println("fib of 100000 : " + okFib(100000, new int[100000+2]));
    System.out.println("time taken : " + (System.currentTimeMillis()-startTime));
  }
}
