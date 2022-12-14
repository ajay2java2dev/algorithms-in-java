package hackerrank.medium;

//https://www.hackerrank.com/challenges/max-array-sum
public class MaxArraySum {

    //this is what I wrote
    static int maxArraySolution (int [] arr) {

        if (arr!=null && arr.length > 0) {

            int mid = arr.length/2;
            int maxSum = -9999;

            for (int i = 0 ; i <= mid ; i++) {

                int maxCount = (mid + 1) - i;
                int skipCount = i + 2;

                while (maxCount > 0) {

                    int left = arr[i];

                    for (int j = skipCount ; j < arr.length; j = j+skipCount) {

                        left = left + arr[j];

                        if (maxSum < left) {
                            maxSum = left;
                        }
                    }

                    maxCount--;
                    skipCount++;
                }

            }

            return maxSum;
        }

        return -1;
    }

    // this was the solution i found online
    static int findMaxSumSolution2 (int [] arr2) {

        if (arr2!=null && arr2.length > 0) {

            int incl = arr2[0];
            int excl = 0;
            int excl_new;
            int i;


            for (i = 1; i < arr2.length ; i++) {
                excl_new = (incl > excl) ? incl : excl;
                incl = excl + arr2[i];
                excl = excl_new;
            }

            return ((incl > excl) ? incl:excl);
        }

        return 0;
    }

    public static void main(String[] args) {
        //int arrTest [] = {2,1,5,8,4};
        //int arr [] = {3,7,4,6,5};



        int arr [] = {3,5,-7,8,10};
        int val = findMaxSumSolution2(arr);
        System.out.println("Max val : " + val);

    }
}
