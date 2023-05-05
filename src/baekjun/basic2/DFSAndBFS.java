package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS {

    static int[][] graph;
    static boolean[] visited;
    static int startNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        int n = Integer.parseInt(s1.split(" ")[0]);

        startNode = Integer.parseInt(s1.split(" ")[2]);
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < Integer.parseInt(s1.split(" ")[1]); i++) {
            String s2 = br.readLine();
            int node1 = Integer.parseInt(s2.split(" ")[0]);
            int node2 = Integer.parseInt(s2.split(" ")[1]);

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        DFS();
        BFS();
    }

    public static void DFS() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;

            sb.append(node).append(" ");
            visited[node] = true;
            int[] nodes = graph[node];

            for (int i = graph.length - 1; i >= 1; i--) {
                if (nodes[i] == 0) continue;

                stack.push(i);
            }
        }

        Arrays.fill(visited, false);
        System.out.println(sb.toString());
    }

    public static void BFS() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(" ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] nodes = graph[node];

            for (int i = 0; i < graph.length; i++) {
                if (nodes[i] == 0) continue;

                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }

        }

        Arrays.fill(visited, false);
        System.out.println(sb.toString());
    }
}
