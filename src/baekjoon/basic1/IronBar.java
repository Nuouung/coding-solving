package baekjoon.basic1;

import java.io.*;
import java.util.Stack;

public class IronBar {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String process = br.readLine();
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < process.length(); i++) {
            if (process.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (process.charAt(i) == ')') {
                stack.pop();

                if (process.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
