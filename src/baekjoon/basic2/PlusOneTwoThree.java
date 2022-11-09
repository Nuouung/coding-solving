package baekjoon.basic2;

import java.util.Scanner;

public class PlusOneTwoThree {

    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        while (N > 0) {
            int x = in.nextInt();
            dp = new int[x + 1];

            dp(x);

            N--;
        }
    }

    static void dp(int x) {
        if (x < 4) {
            if (x == 1) {
                System.out.println(1);
            } else if (x == 2) {
                System.out.println(2);
            } else {
                System.out.println(4);
            }

            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int index = 4;
        while (index <= x) {
            dp[index] = dp[index - 3] + dp[index - 2] + dp[index - 1];

            index++;
        }

        System.out.println(dp[x]);
    }
}
