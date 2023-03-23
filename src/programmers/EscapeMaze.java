package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {

    static int xLen, yLen;
    static int[] S = new int[2];
    static int[] L = new int[2];
    static int[] E = new int[2];
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int bfs(int x, int y, char target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= xLen || nextY >= yLen)
                    continue;

                if (map[nextX][nextY] == 'X' || visited[nextX][nextY] == true)
                    continue;

                if (map[nextX][nextY] == target)
                    return now.cnt + 1;

                q.offer(new Node(nextX, nextY, now.cnt + 1));
                visited[nextX][nextY] = true;
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        int answer = 0;
        int toLever = 0;
        int toEnd = 0;

        map = new char[maps.length][];

        xLen = maps.length;
        yLen = maps[0].length();

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                map[i] = maps[i].toCharArray();

                if (map[i][j] == 'S') {
                    S[0] = i; S[1] = j;
                } else if (map[i][j] == 'L') {
                    L[0] = i; L[1] = j;
                } else if (map[i][j] == 'E') {
                    E[0] = i; E[1] = j;
                }
            }
        }

        visited = new boolean[xLen][yLen];
        toLever = bfs(S[0], S[1], 'L');

        visited = new boolean[xLen][yLen];
        toEnd = bfs(L[0], L[1], 'E');

        if (toLever == -1 || toEnd == -1) return -1;

        return toLever + toEnd;
    }
}
