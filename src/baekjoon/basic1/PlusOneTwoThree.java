package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusOneTwoThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) System.out.println(1);
            else if (n == 2) System.out.println(2);
            else if (n == 3) System.out.println(4);
            else System.out.println(calculate(n));
        }
    }

    private static int calculate(int n) {
        int cal = 0;
        return calculate(1 ,n) + calculate(2, n) + calculate(3, n);
    }

    private static int calculate(int cal, int n) {
        if (cal > n) {
            return 0;
        } else if (cal == n) {
            return 1;
        } else {
            return calculate(cal + 1 ,n) + calculate(cal + 2, n) + calculate(cal + 3, n);
        }
    }

    /*static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(calculate(n));
        }
    }

    private static int calculate(int n) {
        dp = new int[n + 1];

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            return dp[dp.length - 1];
        }
    }*/
}
