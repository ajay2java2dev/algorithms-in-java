package amazon;

public class GCD {

  static int gcd(int dividend, int divisor) {

  	if (dividend == 0) {
      return divisor;
    }
	//NOTE: see how the dividend and divisor are interchanged
    return gcd(divisor % dividend, dividend);
  }

  public static int findGCD(int[] values, int num) {

  	int result = values[0];

  	for (int i = 1; i < num; i++) {
  		result = gcd(values[i], result);
    }

  	return result;
  }

  public static void main(String[] args) {
    int arr[] = {2,4,6,8,16};

    int n = arr.length;

    int gcd = findGCD(arr,n);

    System.out.println(gcd);
  }
}
