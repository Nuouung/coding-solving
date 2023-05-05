package baekjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Island {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int X = 0;
    static int Y = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            if (width == 0 && height == 0) break;

            int[][] map = new int[height][width];
            boolean[][] visited = new boolean[height][width];

            int count = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] == 0) continue;

                    if (!visited[i][j]) {
                        count++;
                        dfs(map, visited, j, i);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{x, y});

        while (!stack.isEmpty()) {
            Integer[] node = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nextX = node[X] + dx[i];
                int nextY = node[Y] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;
                if (map[nextY][nextX] == 0 || visited[nextY][nextX]) continue;

                stack.push(new Integer[]{nextX, nextY});
                visited[nextY][nextX] = true;
            }
        }
    }
}
