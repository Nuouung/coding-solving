package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        if (n < 3) {
            System.out.println(n); // 1 -> 1   2 -> 2
            return;
        }

        solution(n);
        System.out.println(dp[n]);
    }

    static void solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }
    }
}
