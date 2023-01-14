package programmers;


import java.util.List;
import java.util.Stack;

public class DfsPractice {

    static boolean[] visited = new boolean[9];
    static Stack<Integer> stack = new Stack<>();

    static int[][] graph = {{}, {2, 3}, {1, 4, 5}, {1}, {2, 5, 6}, {2, 4, 6, 7}, {4, 5}, {5}};

    public static void main(String[] args) {
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            // 스택에서 하나를 꺼낸다
            Integer nodeIndex = stack.pop();

            // 방문노드 출력
            System.out.print(nodeIndex + " -> ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int node : graph[nodeIndex]) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }
}