package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            solution(sb, stack, expression.charAt(i));
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static void solution(StringBuilder sb, Stack<Character> stack, char c) {
        if ('A' <= c && c <= 'Z') {
            sb.append(c);
            return;
        }

        if (c == ')') {
            while (!(stack.peek() == '(' || stack.isEmpty())) {
                sb.append(stack.pop());
            }

            if (!stack.isEmpty()) stack.pop(); // ( 버리기
            return;
        }

        if (c == '+' || c == '-') {
            if (stack.isEmpty()) {
                stack.push(c);
                return;
            }

            while (stack.peek() != '(') {
                sb.append(stack.pop());
            }

            return;
        }

        stack.push(c);
    }
}
