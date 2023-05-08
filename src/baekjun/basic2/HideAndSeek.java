package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek {

    static int mySpot;
    static int sisterSpot;

    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        mySpot = Integer.parseInt(s.split(" ")[0]);
        sisterSpot = Integer.parseInt(s.split(" ")[1]);

        dp = new int[Math.max(mySpot, sisterSpot) + 2];
        visited = new boolean[Math.max(mySpot, sisterSpot) + 2];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(mySpot);
        dp[mySpot] = 0;
        visited[mySpot] = true;

        while (!queue.isEmpty()) {
            if (visited[sisterSpot]) {
                System.out.println(dp[sisterSpot]);
                System.exit(0);
            }

            int current = queue.poll();
            int distanceOfCurrent = dp[current];

            if (current - 1 >= 0) {
                if (!visited[current - 1]) {
                    dp[current - 1] = distanceOfCurrent + 1;
                    queue.offer(current - 1);
                    visited[current - 1] = true;
                }
            }

            if (current + 1 < dp.length) {
                if (!visited[current + 1]) {
                    dp[current + 1] = distanceOfCurrent + 1;
                    queue.offer(current + 1);
                    visited[current + 1] = true;
                }
            }

            if (current * 2 < dp.length) {
                if (!visited[current * 2]) {
                    dp[current * 2] = distanceOfCurrent + 1;
                    queue.offer(current * 2);
                    visited[current * 2] = true;
                }
            }
        }
    }
}
