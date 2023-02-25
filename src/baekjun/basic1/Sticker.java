package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {

    static int[][] scores;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            scores = new int[Integer.parseInt(br.readLine())][2];
            dp = new long[scores.length][3];
            bingScores(
                    br.readLine().split(" "),
                    br.readLine().split(" "));
            bindDp();

            sb.append(Math.max(dp[scores.length - 1][0], Math.max(dp[scores.length - 1][1], dp[scores.length - 1][2])))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void bindDp() {
        dp[0][0] = 0; // 이 줄에서 아무것도 선택하지 않았을 경우
        dp[0][1] = scores[0][0]; // 이 줄에서 왼쪽 스티커를 선택한 경우
        dp[0][2] = scores[0][1]; // 이 줄에서 오른쪽 스티커를 선택한 경우

        for (int i = 1; i < scores.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + scores[i][0];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + scores[i][1];
        }
    }

    static void bingScores(String[] sArray1, String[] sArray2) {
        for (int i = 0; i < scores.length; i++) {
            scores[i][0] = Integer.parseInt(sArray2[i]);
            scores[i][1] = Integer.parseInt(sArray1[i]);
        }
    }
}
