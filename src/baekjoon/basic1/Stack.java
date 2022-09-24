package baekjoon.basic1;

import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= N; i++) {

            String nextCommand = in.nextLine();

            if (nextCommand.startsWith("pu")) {
                stack.push(Integer.parseInt(nextCommand.substring(5)));
                continue;
            }

            if (nextCommand.startsWith("po")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    Integer integer = stack.pop();
                    sb.append(integer).append("\n");
                }
            }

            if (nextCommand.startsWith("s")) {
                sb.append(stack.size()).append("\n");
            }

            if (nextCommand.startsWith("e")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }

            if (nextCommand.startsWith("t")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
