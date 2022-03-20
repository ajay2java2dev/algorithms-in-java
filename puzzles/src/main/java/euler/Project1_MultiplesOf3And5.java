package euler;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
//
public class Project1_MultiplesOf3And5 {

    public static long oldSumOfMultiplesOf3And5 (long maxInput) {
        //System.out.println(maxInput);
        /* highly inefficient. basic math required to solve this problem */
        long sum = 0;
        if (maxInput >= 3 || maxInput >= 5) {
            for (long i = 3; i < maxInput ; i++) {
                if (i % 3 == 0 || (i % 5 == 0)) {
                   sum += i;
                }
            }
        }
        return sum;
    }

    public static long sumOfMultiplesOf3And5 (long maxInput) {
        long sum = 0;

        if (maxInput >= 3 || maxInput >= 5) {
            long div3 = (maxInput - 1) / 3;
            long div5 = (maxInput - 1) / 5;
            long div15 = (maxInput - 1) / 15;

            long sum3 = (div3 * (div3 + 1) * 3 / 2);
            long sum5 = (div5 * (div5 + 1) * 5 / 2);
            long diff15 = (div15 * (div15 + 1) * 15 / 2);

            sum = sum3 + sum5 - diff15;
        }
        return sum;
    }

    public static void main(String[] args) {
        // old
        System.out.println(oldSumOfMultiplesOf3And5(10));
        System.out.println(oldSumOfMultiplesOf3And5(100));
        System.out.println(oldSumOfMultiplesOf3And5(1000));
        System.out.println(oldSumOfMultiplesOf3And5(1));

        // new
        System.out.println();
        System.out.println(sumOfMultiplesOf3And5(10));
        System.out.println(sumOfMultiplesOf3And5(100));
        System.out.println(sumOfMultiplesOf3And5(1000));
        System.out.println(sumOfMultiplesOf3And5(1));
    }
}
