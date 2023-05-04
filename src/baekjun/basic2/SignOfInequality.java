package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SignOfInequality {

    static int N;
    static String[] signs;

    static boolean[] visited = new boolean[10];
    static int[] storage;

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        signs = br.readLine().split(" ");
        storage = new int[N + 1];

        dfs(0);

        print(max);
        print(min);
    }

    public static void print(long target) {
        StringBuilder sb = new StringBuilder(String.valueOf(target));
        sb.reverse();

        if (sb.length() < N + 1) {
            while (sb.length() < N + 1) {
                sb.append("0");
            }
        }

        System.out.println(sb.reverse());
    }

    public static void dfs(int depth) {
        if (depth >= N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < storage.length; i++) {
                sb.append(storage[i]);
            }

            max = Math.max(max, Long.parseLong(sb.toString()));
            min = Math.min(min, Long.parseLong(sb.toString()));

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                storage[depth] = i;

                if (depth > 0) {
                    if (!isSignOkay(depth)) {
                        visited[i] = false;
                        continue;
                    }
                }

                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isSignOkay(int index) {
        if (signs[index - 1].equals(">")) {
            if (storage[index] < storage[index - 1]) return true;
        } else {
            if (storage[index] > storage[index - 1]) return true;
        }

        return false;
    }
}
