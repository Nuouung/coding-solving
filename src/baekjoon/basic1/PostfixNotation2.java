package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class PostfixNotation2 {

    private static final char[] operators = {'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String source = br.readLine();
        Map<Character, Double> doubleMap = new HashMap<>();

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (isOperator(currentChar)) {
                double numberA = stack.pop();
                double numberB = stack.pop();
                double result = calculate(currentChar, numberA, numberB);

                stack.push(result);
                continue;
            }

            if (doubleMap.get(currentChar) == null) {
                doubleMap.put(currentChar, (double) Integer.parseInt(br.readLine()));
            }

            stack.push(doubleMap.get(currentChar));
        }

        if (stack.size() != 1) {
            System.out.println("ERROR");
        }

        System.out.printf("%.2f%n", stack.pop());
    }

    private static double calculate(char currentChar, double numberA, double numberB) {
        double result = 0;
        switch (currentChar) {
            case '+' :
                result = numberB + numberA;
                break;
            case '-' :
                result = numberB - numberA;
                break;
            case '*' :
                result = numberB * numberA;
                break;
            case '/' :
                result = numberB / numberA;
        }
        return result;
    }

    private static boolean isOperator(char currentChar) {
        for (char operator : operators) {
            if (operator == currentChar) return true;
        }

        return false;
    }
}
