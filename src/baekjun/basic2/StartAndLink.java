package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAndLink {

    static int min = Integer.MAX_VALUE;

    static int[][] table;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] sArray = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(sArray[j]);
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int now, int depth) {
        if (depth >= table.length / 2) {

            int start = 0;
            int link = 0;
            for (int i = 0; i < table.length; i++) {
                for (int j = i + 1; j < table.length; j++) {
                    if (visited[i] && visited[j])
                        start += table[i][j] + table[j][i];
                    else if (!visited[i] && !visited[j])
                        link += table[i][j] + table[j][i];
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for (int i = now; i < table.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
