package hackerrank.easy.hash;

import java.io.IOException;
import java.util.*;

public class SherlocksAnagrams {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {
    int count = 0;
    Map<String, Integer> stringMap = new HashMap();
    Set<String> stringSet = new HashSet<>();

    if (s.length() > 0) {

      char[] charArray = s.toCharArray();

      for (int i = 0; i < charArray.length; i++) {

        for (int j = i + 1; j <= charArray.length; j++) {

          String currentSubString = s.substring(i, j);

          char[] chars = currentSubString.toCharArray();
          Arrays.sort(chars);
          currentSubString = String.valueOf(chars);

          if (stringMap.containsKey(currentSubString)) {
            Integer existingCount = stringMap.get(currentSubString);
            stringMap.put(currentSubString, ++existingCount);
            count++;
          } else {
            stringMap.put(currentSubString, 1);
          }
        }
      }
    }

    return count;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String s1 = "kkkk";
    int result = sherlockAndAnagrams(s1);
    System.out.println("SherlocksAnagrams.main --> result : " + result);
  }
}
