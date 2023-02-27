package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerTriangle {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n][n];

        dp[0][0] = Integer.parseInt(br.readLine());

        setDp(br, n);
        System.out.println(getResult(n));
    }

    private static long getResult(int n) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > result) result = dp[n - 1][i];
        }
        return result;
    }

    private static void setDp(BufferedReader br, int n) throws IOException {
        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < s.length; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + Integer.parseInt(s[0]);
                    continue;
                }

                if (j == s.length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + Integer.parseInt(s[j]);
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + Integer.parseInt(s[j]);
            }
        }
    }
}
