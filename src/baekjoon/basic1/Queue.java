package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        java.util.Queue<Integer> queue = new LinkedList<>();
        int lastNumber = -1;
        while (N-- > 0) {
            String command = br.readLine();
            if (command.contains("push")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                queue.add(number);
                lastNumber = number;
                continue;
            }

            if (command.equals("pop")) {
                Integer maybeNumber = queue.poll();
                if (maybeNumber != null) {
                    sb.append(maybeNumber).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }

                if (queue.size() == 0) {
                    lastNumber = -1;
                }
            }

            if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }

            if (command.equals("empty")) {
                sb.append(queue.size() == 0 ? 1 : 0).append("\n");
            }

            if (command.equals("front")) {
                Integer maybeNumber = queue.peek();
                if (maybeNumber != null) {
                    sb.append(maybeNumber).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }

            if (command.equals("back")) {
                sb.append(lastNumber).append("\n");
            }
        }

        System.out.println(sb);
    }
}
