package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContinuousSum {

    static int[] array;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        initArray(n, br.readLine().split(" "));

        dp[0] = array[0];
        max = array[0];
        for (int i = 1; i < n; i++) {
            // 왼쪽껄 끌고 갈지, 다 버리고 새로 시작할지
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static void initArray(int n, String[] s) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
    }
}
