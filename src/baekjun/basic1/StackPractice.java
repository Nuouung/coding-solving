package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackPractice {

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            doOperation(br.readLine().split(" "));
        }

        System.out.println(sb.toString());
    }

    static void doOperation(String[] operations) {
        if (operations[0].equals("push")) {
            stack.push(Integer.parseInt(operations[1]));
            return;
        }

        if (operations[0].equals("pop")) {
           if (stack.isEmpty()) {
               sb.append("-1").append("\n");
               return;
           }

           sb.append(stack.pop()).append("\n");
           return;
        }

        if (operations[0].equals("size")) {
            sb.append(stack.size()).append("\n");
            return;
        }

        if (operations[0].equals("empty")) {
            if (stack.isEmpty()) {
                sb.append("1").append("\n");
                return;
            }

            sb.append("0").append("\n");
            return;
        }

        if (operations[0].equals("top")) {
            if (stack.isEmpty()) {
                sb.append("-1").append("\n");
                return;
            }

            sb.append(stack.peek()).append("\n");
        }
    }
}
