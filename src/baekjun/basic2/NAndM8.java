package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NAndM8 {

    static int[] numbers;
    static int[] numberBox;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        numbers = new int[m];
        visited = new boolean[n + 1];
        numberBox = new int[n];

        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            numberBox[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(numberBox);

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
            numbers[depth] = numberBox[i - 1];
            dfs(n, m, depth + 1, i);
        }
    }
}
