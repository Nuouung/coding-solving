package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        System.out.println(doDp(N));
    }

    private static int doDp(int N) {
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            int divideThree = (i % 3 == 0) ? dp[i / 3] : 2_000_000_000;
            int divideTwo = (i % 2 == 0) ? dp[i / 2] : 2_000_000_000;
            dp[i] = Math.min(divideThree, Math.min(divideTwo, dp[i - 1])) + 1;
        }

        return dp[N];
    }

}
