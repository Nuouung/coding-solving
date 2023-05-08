package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HideAndSeek4 {

    static int mySpot;
    static int sisterSpot;

    static int[] counts;
    static int[] location;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        mySpot = Integer.parseInt(s.split(" ")[0]);
        sisterSpot = Integer.parseInt(s.split(" ")[1]);

        int maxIndex = Math.max(mySpot, sisterSpot) + 2;

        counts = new int[maxIndex];
        location = new int[maxIndex];
        visited = new boolean[maxIndex];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(mySpot);

        counts[mySpot] = 0;
        location[mySpot] = -1;
        visited[mySpot] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == sisterSpot) {
                System.out.println(counts[current]);

                Stack<Integer> stack = new Stack<>();
                int next = current;
                while (next != -1) {
                    stack.push(next);
                    next = location[next];
                }

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }

                System.out.println(sb.toString());

                System.exit(0);
            }

            if (current - 1 >= 0) {
                if (!visited[current - 1]) {
                    counts[current - 1] = counts[current] + 1;
                    location[current - 1] = current;
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }
            }

            if (current + 1 < maxIndex) {
                if (!visited[current + 1]) {
                    counts[current + 1] = counts[current] + 1;
                    location[current + 1] = current;
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }
            }

            if (current * 2 < maxIndex) {
                if (!visited[current * 2]) {
                    counts[current * 2] = counts[current] + 1;
                    location[current * 2] = current;
                    visited[current * 2] = true;
                    queue.offer(current * 2);
                }
            }
        }
    }
}
