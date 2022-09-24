package baekjoon.basic1;

import java.io.*;
import java.util.Stack;

public class TurnWord {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String sentence = br.readLine() + "\n";

            for (char c : sentence.toCharArray()) {
                if (c != ' ' && c != '\n') {
                    stack.push(c);
                    continue;
                }

                while (!stack.isEmpty()) {
                    Character poppedChar = stack.pop();
                    bw.write(poppedChar);
                }
                bw.write(c);
            }
        }

        bw.flush();
    }
}
