package flyingDoctor;

import java.util.LinkedList;
import java.util.Queue;

public class Number2 {

    public static void main(String[] args) {
        Number2 n = new Number2();
        int[] solution = n.solution(new int[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        });

        System.out.println(solution[0] + " " + solution[1]);
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int maxArea = 0;
    int numberOfFigure = 0;

    public int[] solution(int[][] v) {

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (v[i][j] == 0) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{j, i});
                v[i][j] = 0;
                int area = 1;

                while (!queue.isEmpty()) {
                    int[] xy = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextX = xy[0] + dx[k];
                        int nextY = xy[1] + dy[k];
                        if (nextX < 0 || nextX >= v[0].length || nextY < 0 || nextY >= v.length)
                            continue;

                        if (v[nextY][nextX] == 0)
                            continue;

                        queue.offer(new int[]{nextX, nextY});
                        v[nextY][nextX] = 0;
                        area++;
                    }
                }

                numberOfFigure++;
                maxArea = Math.max(area, maxArea);
            }
        }

        return new int[]{numberOfFigure, maxArea};
    }
}
