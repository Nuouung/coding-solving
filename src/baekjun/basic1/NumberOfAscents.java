package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfAscents {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][10];
        initData();
        bindData();

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n - 1][i]) % 10007;
        }

        System.out.println(result);
    }

    private static void bindData() {
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;

            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }
    }

    private static void initData() {
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
    }
}
