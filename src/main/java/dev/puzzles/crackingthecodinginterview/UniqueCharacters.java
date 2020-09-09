package dev.puzzles.crackingthecodinginterview;

public class UniqueCharacters {

    static boolean isUniqueCharacters (String inputString) {

        if (inputString == null || inputString.length() > 256) {
            return false;
        }

        boolean [] charset = new boolean[256];
        for (Character s : inputString.toCharArray()) {
            int a = s;
            System.out.println(a);
            if (charset[s]) {
                return false;
            }
            charset[s] = true; // the idea here is to create an array of boolean values and to enable the index position
        }
        return true;
    }

    static boolean isUniqueCharsThisBetter(String str) {
        int checker = 0;
        for (int i = 0 ; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println(val);
            if ( (checker & (i << val)) > 0 ) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "Helo";
        System.out.println("UniqueCharacters.main ... " + isUniqueCharacters(test1));
        System.out.println("New UniqueCharacters result ..." + isUniqueCharsThisBetter(test1));
    }

}
