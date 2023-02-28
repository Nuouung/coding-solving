package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecreasingSubsequence {

    static long[] dp;
    static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[Integer.parseInt(br.readLine())];
        array = new long[dp.length];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        long result = Integer.MIN_VALUE;
        for (long l : dp) {
            if (l > result) result = l;
        }

        System.out.println(result);
    }
}
