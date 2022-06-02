package udemy.master_coding_interview;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class TypedOutString {

    static boolean compareTypedOutStrings (String s1, String s2) {

        List<String> s1List = Arrays.asList(s1.split(""));
        LinkedList<String> s1LinkedList = new LinkedList<>(s1List);

        List<String> s2List = Arrays.asList(s2.split(""));
        LinkedList<String> s2LinkedList = new LinkedList<>(s2List);

        ListIterator<String> s1Iterator = s1LinkedList.listIterator();

        while (s1Iterator.hasNext()) {
            if ("#".equalsIgnoreCase(s1Iterator.next())) {
                s1Iterator.remove();
                if (s1Iterator.hasPrevious()) {
                    s1Iterator.previous();
                    s1Iterator.remove();
                }
            }

        }

        ListIterator<String> s2Iterator = s2LinkedList.listIterator();
        while (s2Iterator.hasNext()) {
            if ("#".equalsIgnoreCase(s2Iterator.next())) {
                s2Iterator.remove();
                if (s2Iterator.hasPrevious()) {
                    s2Iterator.previous();
                    s2Iterator.remove();
                }
            }
        }

        String s1New = s1LinkedList.toString();
        String s2New = s2LinkedList.toString();
        return s1New.equals(s2New);
    }

    public static void main(String[] args) {
        String s1 = "ab#z";
        String s2 = "az#z";
        Assertions.assertTrue(compareTypedOutStrings(s1, s2));

        String s3 = "ab##z";
        String s4 = "az#z";
        Assertions.assertFalse(compareTypedOutStrings(s3, s4));
    }
}
