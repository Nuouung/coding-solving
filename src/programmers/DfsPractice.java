package programmers;

import java.io.*;
import java.util.*;

public class DfsPractice {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfs(3); // 주어진 노드를 시작으로 dfs 탐색
//        graph.dfs(); // 비연결형 그래프의 경우
    }
}

class Graph {
    private int V; // 노드의 개수
    private LinkedList<Integer>[] adjoin; // 인접 리스트

    // 생성자
    public Graph(int v) {
        V = v;

        adjoin = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjoin[i] = new LinkedList<>();
        }
    }

    // 노드를 연결 v -> w
    public void addEdge(int v, int w) {
        adjoin[v].add(w);
    }

    // DFS에 의해 사용되는 함수
    public void dfsUtil(int v, boolean[] visited) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v + " ");

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        for (Integer node : adjoin[v]) {

            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 dfsUtil 호출
            if (!visited[node]) {
                dfsUtil(node, visited); // 순환 호출
            }
        }
    }

    // 주어진 노드를 시작 노드로 DFS 탐색
    public void dfs(int v) {
        // 노드의 방문 여부 판단 (초기값: false)
        boolean[] visited = new boolean[V];

        // v를 시작 노드로 dfsUtil 순환 호출
        dfsUtil(v, visited);
    }

    // DFS 탐색
    public void dfs() {
        // 노드의 방문 여부 판단 (초기값: false)
        boolean[] visited = new boolean[V];

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                dfsUtil(i, visited);
            }
        }
    }
}