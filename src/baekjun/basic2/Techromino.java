package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Techromino {

    static int[][] board;
    static int N, M;
    static int max;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        setNM(br.readLine().split(" "));
        setBoard(br);
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(j, i, 0, 0);
                exceptionTechromino(j, i);
            }
        }

        System.out.println(max);
    }

    private static void exceptionTechromino(int x, int y) {
        int left = x + dx[0];
        int right = x + dx[1];
        int up = y + dy[2];
        int down = y + dy[3];

        // ㅗ
        if (!(left < 0 || right >= M || up < 0)) {
            int value = board[y][x] + board[y][left] + board[y][right] + board[up][x];
            max = Math.max(max, value);
        }

        // ㅜ
        if (!(left < 0 || right >= M || down >= N)) {
            int value = board[y][x] + board[y][left] + board[y][right] + board[down][x];
            max = Math.max(max, value);
        }

        // ㅓ
        if (!(left < 0 || up < 0 || down >= N)) {
            int value = board[y][x] + board[y][left] + board[up][x] + board[down][x];
            max = Math.max(max, value);
        }

        // ㅏ
        if (!(right >= M || up < 0 || down >= N)) {
            int value = board[y][x] + board[y][right] + board[up][x] + board[down][x];
            max = Math.max(max, value);
        }
    }

    private static void dfs(int x, int y, int depth, int value) {
        if (depth == 3) {
            value = value + board[y][x];
            max = Math.max(max, value);
            return;
        }

        visited[y][x] = true;
        value = value + board[y][x];

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
                continue;

            if (visited[nextY][nextX])
                continue;

            dfs(nextX, nextY, depth + 1, value);
        }

        visited[y][x] = false;
    }

    private static void setNM(String[] s) {
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
    }

    private static void setBoard(BufferedReader br) throws IOException {
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(s[j]);
        }
    }
}
