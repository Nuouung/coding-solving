package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {

    static long[][] dp;
    static int COMPRESSOR = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[Integer.parseInt(br.readLine())][3];

        dp[0][0] = 1; // 우리에 사자를 넣지 않은 경우
        dp[0][1] = 1; // 우리에 사자를 좌측에 넣은 경우
        dp[0][2] = 1; // 우리에 사자를 우측에 넣은 경우

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % COMPRESSOR;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % COMPRESSOR;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % COMPRESSOR;
        }

        System.out.println((dp[dp.length - 1][0] + dp[dp.length - 1][1] + dp[dp.length - 1][2]) % COMPRESSOR);
    }
}
