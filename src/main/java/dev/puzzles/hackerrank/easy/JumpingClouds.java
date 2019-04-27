package dev.puzzles.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingClouds {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumpCount = 0;
        if (c != null && c.length > 0) {
            for (int i = 0; i < c.length; ) {
                if ((i + 2)< c.length && c[i + 2] == 0) {
                    jumpCount++;
                    i = i + 2;
                    continue;
                } else if ((i + 1)< c.length && c[i + 1] == 0) {
                    jumpCount++;
                    i = i + 1;
                    continue;
                }
                i++;
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
