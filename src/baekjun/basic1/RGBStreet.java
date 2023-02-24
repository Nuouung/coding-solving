package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBStreet {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(br, n);

        long min = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(min);
    }

    private static void solution(BufferedReader br, int n) throws IOException {
        dp = new long[n][3];

        dpInit(br);

        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + Integer.parseInt(s[0]);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Integer.parseInt(s[1]);
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Integer.parseInt(s[2]);
        }
    }

    private static void dpInit(BufferedReader br) throws IOException {
        String[] s = br.readLine().split(" ");
        dp[0][0] = Integer.parseInt(s[0]);
        dp[0][1] = Integer.parseInt(s[1]);
        dp[0][2] = Integer.parseInt(s[2]);
    }
}
