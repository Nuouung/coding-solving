package baekjoon.dfs;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (String s : scanner.nextLine().split(" ")) {
                triangle[i][j] = Integer.parseInt(s);
                j++;
            }
        }

        System.out.println(dp(triangle));
    }

    static int dp(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        int depth = 1;
        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            // 오른쪽
            dp[i][depth] = triangle[i][depth] + dp[i - 1][depth - 1];

            // 가운데 n개
            for (int j = 1; j < depth; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }

            depth++;
        }

        int result = 0;
        for (int i = 0; i < triangle.length; i++) {
            result = Math.max(result, dp[triangle.length - 1][i]);
        }

        return result;
    }
}
