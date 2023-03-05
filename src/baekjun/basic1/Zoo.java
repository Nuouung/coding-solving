package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {

    static long[][] dp;
    static int COMPRESSOR = 9901;

    public static void main(String[] args) throws IOException {
        // 1 1 1
        // 3 2 2
        // 7 5 5
        // ...

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % COMPRESSOR;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % COMPRESSOR;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % COMPRESSOR;
        }

        System.out.println((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % COMPRESSOR);
    }
}
