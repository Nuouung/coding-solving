package baekjoon.basic2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex_Bfs {

    // Breadth-First Search (BFS)
    // Queue로 구현

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.bfs();
    }

    static class Graph {

        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }

            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n2);
            }
        }

        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                for (Node n : r.adjacent) {
                    if (!n.marked) {
                        n.marked = true;
                        stack.push(n);
                    }
                }

                visit(r);
            }
        }

        void bfs() {
            bfs(0);
        }

        void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.marked = true;
            while (!queue.isEmpty()) {
                Node r = queue.poll();
                for (Node n : r.adjacent) {
                    if (!n.marked) {
                        n.marked = true;
                        queue.add(n);
                    }
                }

                visit(r);
            }
        }

        void visit(Node n) {
            System.out.println(n.data);
        }

        static class Node {
            int data;
            LinkedList<Node> adjacent;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }
    }
}
