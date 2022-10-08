package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infixNotation = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixNotation.length(); i++) {
            char character = infixNotation.charAt(i);
            if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                stack.pop(); // ( 제거
            } else if (character == '*' || character == '/') {
                while (stack.peek() == '*' || stack.peek() == '/') {
                    sb.append(stack.pop());
                }

                stack.push(character);
            } else if (character == '+' || character == '-') {

            }
        }
    }
}
