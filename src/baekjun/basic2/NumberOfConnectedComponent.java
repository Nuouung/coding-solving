package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfConnectedComponent {

    static int[][] graph;
    static boolean[] visited;

    static int connectedComponent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1.split(" ")[0]);

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < Integer.parseInt(s1.split(" ")[1]); i++) {
            String s2 = br.readLine();
            int node1 = Integer.parseInt(s2.split(" ")[0]);
            int node2 = Integer.parseInt(s2.split(" ")[1]);

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                bfs(i);
                connectedComponent++;
            }
        }

        System.out.println(connectedComponent);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] nodes = graph[node];

            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == 0) continue;

                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
