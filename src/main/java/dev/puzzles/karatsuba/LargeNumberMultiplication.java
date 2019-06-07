package dev.puzzles.karatsuba;

import java.math.BigInteger;

public class LargeNumberMultiplication {


	public int getSize (BigInteger num) {
		int ctr = 0;
		while (num.longValue()!=0) {
			ctr++;
			num = num.divide(new BigInteger("10"));
		}
		return ctr;
	}

	public BigInteger multiply (BigInteger firstValue, BigInteger secondValue) {

		int size1 = getSize(firstValue);
		int size2 = getSize(secondValue);

		int N = Math.max(size1,size2);

		// if N is small , multiply directly
		if (N < 10) {
			return firstValue.multiply(secondValue);
		}

		N = (N / 2) + (N % 2);

		long m1 = (long) Math.pow(10, N);
		BigInteger m = new BigInteger(String.valueOf(m1));

		BigInteger b = firstValue.divide(m);
		BigInteger a = firstValue.subtract((b.multiply(m)));
		BigInteger d = secondValue.divide(m);
		BigInteger c = secondValue.subtract((b.multiply(m)));

		BigInteger z0 = multiply(a, c);
		BigInteger z1 = multiply(a.add(b), c.add(d));
		BigInteger z2 = multiply(b, d);

		long m2 = (long)Math.pow(10, 2*N);
		BigInteger m2Bg = new BigInteger(String.valueOf(m2));
		return z0.add(((z1.subtract(z0).subtract(z2)).multiply(m)).add(z2.multiply(m2Bg)));
	}

  public static void main(String[] args) {

		//long val1 = 3141592653589793238462643383279502884197169399375105820974944592L;
		//long val2 = 2718281828459045235360287471352662497757247093699959574966967627L;

	  BigInteger bigInteger1 = new BigInteger(
	  		"2718281828459045235360287471352662497757247093699959574966967627");

	  BigInteger bigInteger2 = new BigInteger(
			  "2718281828459045235360287471352662497757247093699959574966967627");

	  LargeNumberMultiplication largeNumberMultiplication = new LargeNumberMultiplication();

	  BigInteger finalVal = largeNumberMultiplication.multiply(bigInteger1,
			  bigInteger2);

	  System.out.println(finalVal);

  }
}
