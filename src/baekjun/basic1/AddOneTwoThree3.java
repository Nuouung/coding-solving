package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOneTwoThree3 {

    static long[] dp = new long[1_000_001];
    static long COMPRESSOR = 1_000_000_009;
    static int progress = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > progress) {
                for (int j = progress + 1; j <= x; j++) {
                    dp[j] = (dp[j - 3] + dp[j - 2] + dp[j - 1]) % COMPRESSOR;
                    progress = j;
                }
            }

            sb.append(dp[x]).append("\n");
        }

        System.out.println(sb);
    }
}
