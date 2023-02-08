package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            solution(br.readLine(), sb);
        }

        System.out.println(sb);
    }

    static void solution(String brackets, StringBuilder sb) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets.toCharArray()) {
            stack.push(bracket);

            if (stack.peek() == ')') {
                stack.pop();

                if (stack.isEmpty() || stack.peek() != '(') {
                    sb.append("NO").append("\n");
                    return;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            sb.append("NO").append("\n");
            return;
        }

        sb.append("YES").append("\n");
    }
}
