package dev.puzzles.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RepeatedStrings {

    static int getAStringCount (String s) {
        int aCountInString = 0;
        if (s!=null && !s.isEmpty()) {
            char[] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                int charTmp = sArr[i];
                if (charTmp == 'a' || charTmp == 'A') {
                    aCountInString++;
                }
            }
        }
        return aCountInString;
    }

    // as per the solutions given in hacker rank
    static long newRepeatedStringApproach (String s, long n){
        long repeatedCount = 0;
        if (s!=null && !s.isEmpty()) {
            char[] sArr = s.toCharArray();
            int aCountInString = getAStringCount(s);
            long remainder = n % s.length();
            repeatedCount = n / s.length() * aCountInString;

            for (int i = 0 ; i < remainder ; i++) {
                if (sArr[i] == 'a')
                    repeatedCount ++ ;
            }

        }
        return repeatedCount;
    }

    // solution as per my approach. Couldn't get all test cases passing.
    // the approach I took was that if say 2 out 3 chars are 'a' then 10 chars should be 10/3 * aCounts should give close
    // to the correct answer. The decimal values (CEIL or FLOOR) should help in getting the remainder added or not.
    // below solution gave 12.5 out 20.
    static long myRepeatedString(String s, long n) {
        long repeatedCount = 0;
        if (s!=null && !s.isEmpty()) {
            int aCountInString = getAStringCount(s);
            char[] sArr = s.toCharArray();
            if (aCountInString==0) {
                return 0;
            }

            if (s.length() == 1) {
                repeatedCount = n;
            } else {
                BigDecimal bg1 = new BigDecimal(n);
                BigDecimal bg2 = new BigDecimal(sArr.length);
                bg2 = bg1.divide(bg2,2,RoundingMode.CEILING);

                bg2 = (bg2).multiply(new BigDecimal(aCountInString));
                repeatedCount = bg2.setScale(0,RoundingMode.HALF_EVEN).longValue();

            }
        }
        return repeatedCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = newRepeatedStringApproach(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
