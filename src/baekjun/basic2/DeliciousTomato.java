package baekjun.basic2;

import java.io.*;
import java.util.*;

public class DeliciousTomato {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();

        int width = Integer.parseInt(s1.split(" ")[0]);
        int height = Integer.parseInt(s1.split(" ")[1]);

        int[][] tomatoes = new int[height][width];

        int max = 0;

        boolean[][] visited = new boolean[height][width];
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                tomatoes[i][j] = Integer.parseInt(s2[j]);

                // 익은 토마토를 모두 큐에 넣는다
                if (s2[j].equals("1")) {
                    queue.offer(new Tomato(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = tomato.x + dx[i];
                int nextY = tomato.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) continue;
                if (visited[nextY][nextX]) continue;
                if (tomatoes[nextY][nextX] == -1) continue;

                tomatoes[nextY][nextX] = 1;
                visited[nextY][nextX] = true;

                queue.offer(new Tomato(nextX, nextY, tomato.ripeDate + 1));

                max = Math.max(max, tomato.ripeDate + 1);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tomatoes[i][j] == 0) {
                    max = -1;
                    break;
                }
            }
        }

        System.out.println(max);
    }

    static class Tomato {
        int x;
        int y;
        int ripeDate;

        public Tomato(int x, int y, int ripeDate) {
            this.x = x;
            this.y = y;
            this.ripeDate = ripeDate;
        }
    }
}
