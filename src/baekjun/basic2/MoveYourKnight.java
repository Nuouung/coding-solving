package baekjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MoveYourKnight {

    static int X = 0;
    static int Y = 1;
    static int COUNT = 2;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int x = 0; x < n; x++) {
            int lengthOfBoard = Integer.parseInt(br.readLine());

            String[] s1 = br.readLine().split(" ");
            int[] startPosition = new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])};

            String[] s2 = br.readLine().split(" ");
            int[] endPosition = new int[]{Integer.parseInt(s2[0]), Integer.parseInt(s2[1])};

            Queue<Integer[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[lengthOfBoard][lengthOfBoard];

            queue.offer(new Integer[]{startPosition[X], startPosition[Y], 0});
            visited[startPosition[Y]][startPosition[X]] = true;


            int result = 0;

            while (!queue.isEmpty()) {
                Integer[] node = queue.poll();

                if (node[X] == endPosition[X] && node[Y] == endPosition[Y]) {
                    result = node[COUNT];
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nextX = node[X] + dx[i];
                    int nextY = node[Y] + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= lengthOfBoard || nextY >= lengthOfBoard) continue;
                    if (visited[nextY][nextX]) continue;

                    queue.offer(new Integer[]{nextX, nextY, node[COUNT] + 1});
                    visited[nextY][nextX] = true;
                }
            }

            System.out.println(result);
        }
    }
}
