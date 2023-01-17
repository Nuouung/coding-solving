package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Triangle {

    static List<Graph> graphList = new ArrayList<>();
    static Stack<Graph> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int index = 0;
        for (int i = 0; i < n; i++) {
            int depth = i + 1;
            for (String s : br.readLine().split(" ")) {
//                int parentNodeIndex = index - (depth - 1);
                int childNodeIndex = index + depth;
                List<Integer> linkedNodeIndexes = getLinkedNodeIndexes(childNodeIndex);

                graphList.add(new Graph(index, depth, Integer.parseInt(s), linkedNodeIndexes));
                index++;
            }
        }

        int result = dfs(n);
        System.out.println(result);
    }

    private static int dfs(int n) {
        int result = 0;

//        boolean[] visited = new boolean[n];
        int[] valueArray = new int[n];

        stack.push(graphList.get(0));
//        visited[0] = true;

        while (!stack.isEmpty()) {
            Graph current = stack.pop();
            if (current.depth < n) {
                List<Integer> linkedNodeIndexes = current.linkedNodeIndexes;
                stack.push(graphList.get(linkedNodeIndexes.get(0)));
                stack.push(graphList.get(linkedNodeIndexes.get(1)));
            }

            valueArray[current.depth - 1] = current.value;
            if (current.depth == n) {
                int temp = 0;
                for (int i : valueArray) {
                    temp += i;
                }

                if (temp > result) result = temp;
            }
        }

        return result;
    }

    private static List<Integer> getLinkedNodeIndexes(int childNodeIndex) {
        LinkedList<Integer> linkedNodeIndexes = new LinkedList<>();
        linkedNodeIndexes.add(childNodeIndex);
        linkedNodeIndexes.add(childNodeIndex + 1);

        return linkedNodeIndexes;
    }

    static class Graph {
        int index, depth, value;
        List<Integer> linkedNodeIndexes;

        Graph(int index, int depth, int value, List<Integer> linkedNodeIndexes) {
            this.index = index;
            this.depth = depth;
            this.value = value;
            this.linkedNodeIndexes = linkedNodeIndexes;
        }
    }
}
