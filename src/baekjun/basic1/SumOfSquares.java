package baekjun.basic1;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSquares {

    static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int pow = getPow(i);

            for (int j = 1; j <= pow; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int) Math.pow(j, 2)] + 1);
            }
        }

        System.out.println(dp[n]);
    }

    private static int getPow(int n) {
        int pow = 1;
        while (Math.pow(pow + 1, 2) <= n)
            pow++;

        return pow;
    }

    // dp top-down -> fail(시간초과)
    /*static void recur(int x, int depth) {
        if (x == 0) {
            min = Math.min(min, depth);
            return;
        }

        int pow = 1;
        while (Math.pow(pow + 1, 2) <= x)
            pow++;

        for (int i = pow; i >= 1; i--) {
            recur(x - (int) Math.pow(i, 2), depth + 1);
        }
    }*/

    // greedy -> fail
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int pow = 1;
        while (Math.pow(pow + 1, 2) <= n)
            pow++;

        int result = 0;
        while (n > 0) {
            for (int i = pow; i >= 1; i--) {
                if (n >= Math.pow(i, 2)) {
                    n -= (int) Math.pow(i, 2);
                    break;
                }
            }

            result++;
        }

        System.out.println(result);
    }*/
}
