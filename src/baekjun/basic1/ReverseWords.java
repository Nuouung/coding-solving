package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            solution(br.readLine().split(" "), sb);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solution(String[] words, StringBuilder sb) {
        Stack<Character> stack = new Stack<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                stack.push(c);
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            sb.append(" ");
        }
    }
}
