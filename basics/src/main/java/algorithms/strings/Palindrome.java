package algorithms.strings;

import java.util.Locale;

public class Palindrome {
    static boolean isPalindrome(String palStr){
        if (palStr == null || palStr.isEmpty()) {
            return false;
        }
        String cleanReg = "[^a-zA-Z0-9]";
        palStr = palStr.replaceAll(cleanReg, "").toLowerCase();
        String [] chars = palStr.split("");
        int left = 0, right = palStr.length() -1;
        for (int i = left; i < right; i++) {
            if (chars[left].equalsIgnoreCase(chars[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(isPalindrome("ABCCba"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
