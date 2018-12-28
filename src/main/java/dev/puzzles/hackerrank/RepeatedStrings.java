package dev.puzzles.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RepeatedStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long repeatedCount = 0;
        if (s!=null && !s.isEmpty()) {
            float aCountInString = 0;
            char [] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++){
                int charTmp = sArr[i];
                if (charTmp == 'a' || charTmp == 'A') {
                    aCountInString++;
                }
            }

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

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
