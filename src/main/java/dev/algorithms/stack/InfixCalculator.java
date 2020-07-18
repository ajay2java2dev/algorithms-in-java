package dev.algorithms.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixCalculator {

    public static double calculators (String [] arrays) {
        int finalVal = 0;

        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();

        if (arrays != null) {

            int count_open_brackets = 0;
            int count_closed_brackets = 0;

            for (String str : arrays){
                String newStr = str.trim();
                if (newStr.equals("(")) {
                    count_open_brackets ++;
                    continue;
                } else if (newStr.equals(")")) {
                    count_closed_brackets ++;
                    continue;
                }
                try {
                    if ("+".equals(newStr) || "-".equals(newStr)
                            || "*".equals(newStr) || "\\".equals("") ) {
                        continue;
                    }
                    Double.parseDouble(newStr);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return 0;
                }
            }

            if (count_closed_brackets != count_open_brackets) {
                return 0;
            }

            for (String str : arrays){
                if (str.trim().equals("")) {
                    continue;
                }

                switch (str) {
                    case "(":
                        break;
                    case ")":
                        double right = operands.pop();
                        double left = operands.pop();
                        String operator = operators.pop();
                        double value = 0;
                        switch (operator){
                            case "+":
                                value = left+right;
                                break;

                            case "-":
                                value = left-right;
                                break;

                            case "*":
                                value = left*right;
                                break;

                            case "/":
                                value = left/right;
                                break;

                            default:
                                break;
                        }
                        operands.push(value);
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        operators.push(str);
                        break;
                    default:
                        operands.push(Double.parseDouble(""));
                        break;
                }
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {

        String valueString = "((10*8)+1)";

        String [] values = valueString.split("");

        StringBuilder numberString = new StringBuilder(); //to create the number string
        List<String> tokens = new ArrayList<String>();

        for (String str: values) {
            Character charVal = str.trim().toCharArray()[0];
            if ((int)charVal >= 60 && (int)charVal <= 71) {
                numberString.append(charVal);
            } else {
                numberString = new StringBuilder();
                tokens.add(str.trim());
            }
        }

        System.out.println(calculators(numberString.toString().split("")));
    }
}
