package baekjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ABCDE {

    static int n;
    static int m;
    static List<List<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        n = Integer.parseInt(s1.split(" ")[0]);
        m = Integer.parseInt(s1.split(" ")[1]);

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String s2 = br.readLine();
            int node1 = Integer.parseInt(s2.split(" ")[0]);
            int node2 = Integer.parseInt(s2.split(" ")[1]);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 0; i < n; i++) {
            if (result == 1) break;
            DFS(i, 0);
        }

        System.out.println(result);
    }

    public static void DFS(int node, int depth) {
        if (depth >= 5) {
            result = 1;
            return;
        }

        if (result == 1) return;

        if (!visited[node]) {
            List<Integer> nodes = graph.get(node);
            visited[node] = true;

            for (int n : nodes) {
                DFS(n, depth + 1);
            }

            visited[node] = false;
        }
    }
}
