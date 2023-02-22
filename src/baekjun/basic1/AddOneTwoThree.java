package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOneTwoThree {

    static long[] dp = new long[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 1) System.out.println(1);
            else if (x == 2) System.out.println(2);
            else if (x == 3) System.out.println(4);
            else System.out.println(solution(x));
        }
    }

    private static long solution(int x) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < x + 1; i++)
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];

        return dp[x];
    }
}
