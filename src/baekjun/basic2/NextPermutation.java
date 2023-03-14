package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] visited;
    static int[] storage;
    static int[] target;
    static int n;
    static boolean gotcha = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        setTarget(br);
        storage = new int[n];

        dfs(0);

        if (gotcha) System.out.println(-1);
    }

    private static void dfs(int depth) {
        if (depth >= n) {
            if (gotcha) {
                StringBuilder sb = new StringBuilder();
                for (int n : storage) {
                    sb.append(n).append(" ");
                }
                System.out.println(sb);

                gotcha = false;

                return;
            }

            boolean isTarget = true;
            for (int i = 0; i < n; i++) {
                if (target[i] != storage[i]) {
                    isTarget = false;
                    break;
                }
            }

            if (isTarget)
                gotcha = true;

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                storage[depth] = i + 1;

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }

    private static void setTarget(BufferedReader br) throws IOException {
        target = new int[n];
        String[] sArray = br.readLine().split(" ");
        for (int i = 0; i < sArray.length; i++) {
            target[i] = Integer.parseInt(sArray[i]);
        }
    }
}
