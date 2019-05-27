package dev.puzzles.hackerrank.easy.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/*
    https://www.hackerrank.com/challenges/counting-valleys/problem
    1) A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    2) A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
    3) Given Gary's sequence of up and down steps during his last hike, find and print the number of VALLEYS he walked through.

    NOTE : The question here was how many Valleys and not current level.
    Q. What did I learn from this problem ?
    Ans. The problem was a easy level category but still I made mistake in coding because I din't read what was to be returned.
    I saw the example and assumed that the final level (below or above or at sea level) is what should be returned.

    Q. How did I, after making the mistake, come to solution ?
    Ans.  I didn't have any clue as to what was wrong (was too lazy to read the problem statement again). Then after struggling for quite sometime
    saw the answers submitted by other users. It's not until I saw the return value, I decided to go back and read the problem statement.

    Q. Did I face any other issues with this problem or with Hacker Rank setup ?
    Ans. The hacker rank setup now needs a file OUTPUT_PATH env variable to be set for the file output to be spit out.
 */
public class CountingValleys {
    private static final Scanner scanner = new Scanner(System.in);

    private static int countingValleys(int n, String s) {
        int level = 0;
        int valley = 0;
        if (s != null && !s.isEmpty()) {
            char[] chars = s.toCharArray();
            for (Character char1 : chars) {
                if ('U' == char1) {
                    level++;
                    if (level == 0) {
                        valley++;
                    }
                } else if ('D' == char1) {
                    level--;
                }
            }
        }
        return valley;
    }

    public static void main(String[] args) {

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s = scanner.nextLine();

            int result = countingValleys(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
