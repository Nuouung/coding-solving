package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling3 {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        if (n > 1) {
            dp[2] = 3;

            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * 3;
                int j = i - 4;
                while (j >= 0) {
                    dp[i] += j == 0 ? 2 : dp[j] * 2;
                    j -= 2;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
