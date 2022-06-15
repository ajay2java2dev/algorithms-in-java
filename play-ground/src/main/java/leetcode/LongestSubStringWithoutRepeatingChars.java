package leetcode;

import org.junit.jupiter.api.Assertions;

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

    //https://www.udemy.com/course/master-the-coding-interview-big-tech-faang-interviews/learn/lecture/22188586#questions/17687632
    static long optimisticLongestSubstring (String subString) {
        if (subString == null || subString.isEmpty()) {
            return 0;
        }
        int longestSubString=0;
        String [] chars = subString.split("");
        Map<String, Integer> charMap = new HashMap<>();
        int left = 0, currentLength =0;

        for (int right = 0; right < chars.length; right++) {
            String currentChar = chars[right];
            if (!charMap.containsKey(currentChar)) {
                charMap.put(currentChar, right);
                currentLength++;
            } else {
                int prevSeenPos = charMap.get(currentChar);
                if (prevSeenPos >= left) {
                    left = prevSeenPos + 1;
                }
                charMap.put(currentChar, right);
                currentLength = right - left + 1;
            }
            longestSubString = Math.max(longestSubString, currentLength);
        }
        return longestSubString;
    }

    public static void main(String[] args) {
        Assertions.assertEquals(3,countLongestSubstring("abccabb"));
        Assertions.assertEquals(4,optimisticLongestSubstring("abcbdaac"));
        Assertions.assertEquals(3,optimisticLongestSubstring("pwwkew"));
    }
}
