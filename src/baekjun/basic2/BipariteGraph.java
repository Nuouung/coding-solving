package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipariteGraph {

    static ArrayList<ArrayList<Integer>> graph;
    static int color = 1; // 1 (빨강), -1 (파랑)

    static int[] colorBoard;

    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int index = 0; index < N; index++) {
            String s1 = br.readLine();
            int n = Integer.parseInt(s1.split(" ")[0]);

            graph = new ArrayList<>();
            colorBoard = new int[n + 1];
            flag = true;

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < Integer.parseInt(s1.split(" ")[1]); i++) {
                String s2 = br.readLine();
                int node1 = Integer.parseInt(s2.split(" ")[0]);
                int node2 = Integer.parseInt(s2.split(" ")[1]);

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            for (int i = 1; i < graph.size(); i++) {
                if (!flag) break;

                if (colorBoard[i] == 0) {
                    colorBoard[i] = color; // 초기값 1 (빨강)
                    bfs(i);
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }


    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ArrayList<Integer> nodes = graph.get(node);

            for (int n : nodes) {
                if (colorBoard[n] == 0) {
                    colorBoard[n] = colorBoard[node] * -1;
                    queue.offer(n);
                    continue;
                }

                // 인접한 노드가 같은 색을 가지고 있다는 것은 이분 그래프가 아니라는 의미
                if (colorBoard[n] == colorBoard[node]) {
                    flag = false;
                    return;
                }
            }
        }
    }
}
