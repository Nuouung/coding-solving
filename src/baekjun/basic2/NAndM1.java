package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM1 {

    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        numbers = new int[m];
        visited = new boolean[n + 1];

        dfs(n, m, 0);
    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[depth] = i;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
