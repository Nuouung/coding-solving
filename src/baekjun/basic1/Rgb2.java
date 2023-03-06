package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rgb2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];

        for (int i = 0; i < rgb.length; i++) {
            String[] s = br.readLine().split(" ");

            rgb[i][0] = Integer.parseInt(s[0]);
            rgb[i][1] = Integer.parseInt(s[1]);
            rgb[i][2] = Integer.parseInt(s[2]);
        }

        long minR = getMin(rgb, 0);
        long minG = getMin(rgb, 1);
        long minB = getMin(rgb, 2);

        System.out.println(Math.min(minR, Math.min(minG, minB)));
    }

    static long getMin(int[][] rgb, int index) {
        long[][] dp = setDp(rgb, index);
        return Math.min(dp[rgb.length - 1][0], Math.min(dp[rgb.length - 1][1], dp[rgb.length - 1][2]));
    }

    static long[][] setDp(int[][] rgb, int index) {
        long[][] dp = new long[rgb.length][3];

        dp[0][0] = index == 0 ? rgb[0][0] : 1001;
        dp[0][1] = index == 1 ? rgb[0][1] : 1001;
        dp[0][2] = index == 2 ? rgb[0][2] : 1001;

        for (int i = 1; i < rgb.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];

            if (i == rgb.length - 1) {
                dp[i][0] = index == 0 ? Integer.MAX_VALUE : dp[i][0];
                dp[i][1] = index == 1 ? Integer.MAX_VALUE : dp[i][1];
                dp[i][2] = index == 2 ? Integer.MAX_VALUE : dp[i][2];
            }
        }

        return dp;
    }
}
