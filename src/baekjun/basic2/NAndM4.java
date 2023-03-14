package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM4 {

    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        numbers = new int[m];

        dfs(n, m, 0, 1);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth, int start) {
        if (depth == m) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            numbers[depth] = i;
            dfs(n, m, depth + 1, i);
        }
    }
}
