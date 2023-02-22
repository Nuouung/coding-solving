package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(3);
            return;
        }

        doDp(n);
        System.out.println(dp[n]);
    }

    // 공식 - (-1 케이스) + 2(-2 케이스)
    static void doDp(int n) {
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10_007;
        }
    }
}
