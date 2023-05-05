package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartment {

    static int[][] map;
    static boolean[][] visited;

    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) continue;

                if (!visited[i][j]) {
                    bfs(j, i);
                    count++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(count);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    public static void bfs(int x, int y) {
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[]{x, y});
        visited[y][x] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int X = 0;
        int Y = 1;

        int size = 1;

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node[X] + dx[i];
                int nextY = node[Y] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;

                if (map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                    queue.offer(new Integer[]{nextX, nextY});
                    visited[nextY][nextX] = true;
                    size++;
                }
            }
        }

        list.add(size);
    }
}
