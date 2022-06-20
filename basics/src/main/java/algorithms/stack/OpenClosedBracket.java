package algorithms.stack;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class OpenClosedBracket {

    static Map<String,String> openClosedBracketMap = new HashMap<>();
    static {
        openClosedBracketMap.put("]","[");
        openClosedBracketMap.put(")","(");
        openClosedBracketMap.put("}","{");
    }


    static boolean isValid (String bracketString) {
        if (bracketString == null)
            return false;
        if (bracketString.isEmpty())
            return true;

        String [] brackets = bracketString.split("");
        Stack<String> bracketStack= new Stack<>();
        int i = 0;
        while (i < brackets.length) {
            String bracket = brackets[i];
            if (openClosedBracketMap.containsKey(bracket)) {
                //we got a closed bracket so pop from stack
                if (bracketStack.isEmpty()) {
                    return false;
                }

                String brackerTmp = openClosedBracketMap.get(bracket);
                if (!brackerTmp.equalsIgnoreCase(bracketStack.pop())) {
                    return false;
                }
            } else {
                bracketStack.push(brackets[i]);
            }
            i++;
        }

        if (!bracketStack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "{[{[]}]}";
        Assertions.assertTrue(isValid(test1));
        String test2 = "]";
        Assertions.assertFalse(isValid(test2));
    }
}
