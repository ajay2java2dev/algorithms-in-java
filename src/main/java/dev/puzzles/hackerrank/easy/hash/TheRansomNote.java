package dev.puzzles.hackerrank.easy.hash;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

//Submitted below to : https://www.hackerrank.com/challenges/ctci-ransom-note
// Test cases passed : 21
public class TheRansomNote {

  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {

    if (magazine.length > 0 && note.length > 0) {
      List<String> magList = Arrays.asList(magazine);
      List<String> noteList = Arrays.asList(note);

      Map<String,Long> newMagMap =
          magList.stream().map(String::toLowerCase)
		          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

      List<String> newNoteList =
          noteList.stream().map(String::toLowerCase).collect(Collectors.toList());

      for (String notStr : newNoteList) {
        if (!newMagMap.containsKey(notStr)
            || newMagMap.get(notStr) <= 0) {
          System.out.println("No");
          return;
        } else{
	        long count = newMagMap.get(notStr);
	        newMagMap.put(notStr, --count);
        }
      }

      System.out.println("Yes");
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
