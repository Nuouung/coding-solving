package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyingCard2 {

    static int[] price = new int[10_001];
    static long[] dp = new long[10_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        setPrice(br.readLine().split(" "));
        setDp(n);

        System.out.println(dp[n]);
    }

    private static void setDp(int n) {
        for (int i = 1; i < n + 1; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                min = Math.min(min, price[j] + dp[i - j]);
            }

            dp[i] = min;
        }
    }

    private static void setPrice(String[] s) {
        for (int i = 0; i < s.length; i++) {
            price[i + 1] = Integer.parseInt(s[i]);
        }
    }
}
