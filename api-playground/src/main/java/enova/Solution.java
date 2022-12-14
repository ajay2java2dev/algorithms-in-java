package enova;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Solution {

  static List<String> commonVowels = null;

  static {
    commonVowels = new ArrayList<String>(6);
    commonVowels.add("a");
    commonVowels.add("e");
    commonVowels.add("i");
    commonVowels.add("o");
    commonVowels.add("u");
  }

  // returns {{vowel}} appears {{count}} time(s)
  public String solution(String S) {
    // write your code in Java SE 8

    if (S != null && S.length() > 0) {

      // Tree Map will default sort by the key. But not really required here.
      Map<String, Integer> vowelCountMap = new LinkedHashMap<String, Integer>();

      char[] chars = S.toLowerCase().toCharArray();

      // mapping fxn
      for (int i = 0; i < chars.length; i++) {
        String charTmp = String.valueOf(chars[i]);
        if (commonVowels.contains(charTmp)) {
          // make sure to increment the internal counter
          if (vowelCountMap.containsKey(charTmp)) {
            Integer count = vowelCountMap.get(charTmp);
            count = count + 1;
            vowelCountMap.put(charTmp, count);
          } else {
            vowelCountMap.put(charTmp, 1);
          }
        }
      }

      // sort by value and then by key. Lets use Java 8 for this.
      Map<String, Integer> newVowelCountMapByValue =
          vowelCountMap.entrySet().stream()
              .sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
              .collect(
                  toMap(
                      Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

      // reduce fxn
      int maxCount = 0;
      StringBuilder buildFinalString = new StringBuilder();

      for (Map.Entry entry : newVowelCountMapByValue.entrySet()) {

        String keyTmp = (String) entry.getKey();
        Integer countTmp = (Integer) entry.getValue();

        if (countTmp >= maxCount) {
          maxCount = countTmp;

          String time = "time";
          if (maxCount > 1) {
            time = "times";
          }

          buildFinalString
              .append(keyTmp)
              .append(" appears ")
              .append(countTmp)
              .append(" ")
              .append(time)
              .append("\n");
        } else {
          break;
        }
      }

      // FIXME : Remove last \n char

      return buildFinalString.toString();
    }

    return null;
  }

  public static void main(String[] args) {
    //

    String s = "this is sentence aaa";
    Solution solution = new Solution();
    String s1 = solution.solution(s);
    System.out.println(s1);

    /*
    s = "lexicon";
    solution =new enova();
    s1 = solution.solution(s);
    System.out.println(s1);

    s = "e ";
    solution =new enova();
    s1 = solution.solution(s);
    System.out.println(s1);*/
  }

}
