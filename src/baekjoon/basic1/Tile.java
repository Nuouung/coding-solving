package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 1 = 1
        // 2 = 2
        // 3 = 3
        // 4 = 5
        // 5 = 8
        // fn = f(n-1) + f(n-2)
        // 피보나치 수열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        countTile();

        System.out.println(dp[n] % 1000000007);
    }

    private static void countTile() {
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
    }
}
