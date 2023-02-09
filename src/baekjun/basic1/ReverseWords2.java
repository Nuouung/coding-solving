package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWords2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isBracketOn = false;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '<') {
                emptyStack(stack, sb);

                isBracketOn = true;
                sb.append(sentence.charAt(i));
                continue;
            }

            if (sentence.charAt(i) == ' ') {
                emptyStack(stack, sb);

                sb.append(sentence.charAt(i));
                continue;
            }

            if (sentence.charAt(i) == '>') {
                isBracketOn = false;
                sb.append(sentence.charAt(i));
                continue;
            }

            if (isBracketOn) {
                sb.append(sentence.charAt(i));
                continue;
            }

            stack.push(sentence.charAt(i));
        }

        emptyStack(stack, sb);

        System.out.println(sb);
    }

    private static void emptyStack(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
