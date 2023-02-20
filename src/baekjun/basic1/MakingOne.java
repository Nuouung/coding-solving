package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingOne {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        initDp(n);

        for (int i = 2; i <= n; i++) {
            dp[i] = getMinValue(i) + 1;
        }

        System.out.println(dp[n]);
    }

    private static void initDp(int n) {
        dp = new int[n + 1];
    }

    private static int getMinValue(int i) {
        return Math.min(dp[i - 1], Math.min(
                (i % 2 == 0) ? dp[i / 2] : Integer.MAX_VALUE,
                (i % 3 == 0) ? dp[i / 3] : Integer.MAX_VALUE));
    }
}
