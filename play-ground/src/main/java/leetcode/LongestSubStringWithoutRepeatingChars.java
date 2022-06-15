package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars {

    static long countLongestSubstring (String subString) {
        String [] chars = subString.split("");
        if (subString.isEmpty()) {
            return 0;
        }

        int longestSubstring = 0;
        for (int left = 0; left < chars.length; left++) {
            Map<String, Boolean> seeCharsMap = new HashMap<>();
            int currentLength = 0;
            for (int right = left; right < chars.length; right++) {
                String key = chars[right];
                if (!seeCharsMap.containsKey(key)) {
                    seeCharsMap.put(key, Boolean.TRUE);
                    currentLength++;
                    longestSubstring = Math.max(longestSubstring, currentLength);
                } else {
                    break;
                }
            }
        }

        return longestSubstring;
    }

    static long optimisticLongestSubstring (String subString) {
        if (subString == null || subString.isEmpty()) {
            return 0;
        }
        int longestSubString=0;
        String [] chars = subString.split("");
        Map<String, Integer> charMap = new HashMap<>();
        int left = 0, right = 0;

        int currentLength =0;
        for (int i = 0; i < chars.length; i++) {
            String currentChar = chars[i];
            if (!charMap.containsKey(currentChar)) {
                charMap.put(chars[i], i);
                currentLength++;
            } else {
                if (charMap.get(currentChar) < left) {
                    charMap.put(currentChar, i);
                } else {
                    left = charMap.get(currentChar) + 1;
                    charMap.put(currentChar, i);
                }
                currentLength = right - left + 1;
            }
            longestSubString = Math.max(longestSubString, currentLength);
            right++;
        }
        return longestSubString;
    }

    public static void main(String[] args) {
        System.out.println(countLongestSubstring("abccabb"));
        System.out.println(optimisticLongestSubstring("abcbdaac"));
        System.out.println(optimisticLongestSubstring("pwwkew"));
    }
}
