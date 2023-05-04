package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOneTwoThree_dp {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target == 1) {
                System.out.println(1);
                continue;
            }

            if (target == 2) {
                System.out.println(2);
                continue;
            }

            if (target == 3) {
                System.out.println(4);
                continue;
            }

            dp = new int[target + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= target; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }

            System.out.println(dp[target]);
        }
    }
}
