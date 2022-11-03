package baekjoon.basic2;

import java.util.Scanner;

public class NAndM1 {

   static int[] array;
   static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        array = new int[N];
        visit = new boolean[M];

        dfs(N, M, 0);
    }

    private static void dfs(int N, int M, int depth) {
        if (depth == N) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
