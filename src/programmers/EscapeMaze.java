package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited;

    public int solution(String[] maps) {
        visited = new boolean[maps[0].length()][maps.length];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].indexOf('S') != -1) {
                startX = i;
                startY = maps[i].indexOf('S');
                break;
            }
        }

        int toLever = bfs(startX, startY, maps, 'L');

        startX = 0;
        startY = 0;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].indexOf('L') != -1) {
                startX = i;
                startY = maps[i].indexOf('L');
                break;
            }
        }

        visited = new boolean[maps[0].length()][maps.length];

        int toEnd = bfs(startX, startY, maps, 'E');

        if (toLever == -1 || toEnd == -1) return -1;

        return toLever + toEnd;
    }

    int bfs(int startX, int startY, String[] maps, char target) {
        queue.offer(new Node(startX, startY, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (maps[node.y].charAt(node.x) == target)
                return node.count;

//            if (maps[node.y].charAt(node.x) == 'L') node.isLeverPass = true;

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if (newX >= 0 && newX < maps[0].length() && newY >= 0 && newY < maps.length) {
                    if (maps[newY].charAt(newX) == 'X') continue;
                    if (visited[newY][newX]) continue;

                    queue.offer(new Node(newX, newY, node.count + 1));
                    visited[newY][newX] = true;

                }
            }
        }

        return -1;
    }

    class Node {
        int x;
        int y;
        int count;
        boolean isLeverPass;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isLeverPass = false;
        }

        public Node(int x, int y, int count, boolean isLeverPass) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isLeverPass = isLeverPass;
        }
    }
}
