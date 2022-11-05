package baekjoon.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NAndM3 {

    static StringBuilder sb = new StringBuilder();

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);

        array = new int[M];

        dfs(N, M, 0);
        System.out.println(sb.toString());
    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            array[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }
}
