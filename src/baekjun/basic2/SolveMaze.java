package baekjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SolveMaze {

    static int N;
    static int M;

    static int X = 0;
    static int Y = 1;
    static int COUNT = 2;

    static int[][] maze;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        N = Integer.parseInt(s1.split(" ")[0]);
        M = Integer.parseInt(s1.split(" ")[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s2 = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(s2.charAt(j));
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0, 0, 1});
        visited[0][0] = true;

        int resultCount = 0;

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            if (node[X] == M - 1 && node[Y] == N - 1) {
                resultCount = node[COUNT];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = node[X] + dx[i];
                int nextY = node[Y] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if (maze[nextY][nextX] == 0) continue;
                if (visited[nextY][nextX]) continue;

                queue.offer(new Integer[]{nextX, nextY, node[COUNT] + 1});
                visited[nextY][nextX] = true;
            }
        }

        System.out.println(resultCount);
    }
}
