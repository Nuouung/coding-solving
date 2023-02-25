package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {

    static int[] wines;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wines = new int[Integer.parseInt(br.readLine())];
        dp = new long[wines.length];
        bindWines(br);

        for (int i = 0; i < wines.length; i++) {
            // oox oxo xoo
            if (i == 0) {
                dp[0] = wines[0];
                continue;
            }

            if (i == 1) {
                dp[1] = dp[0] + wines[1];
                continue;
            }

            if (i == 2) {
                dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));
                continue;
            }

            dp[i] = Math.max(
                    dp[i - 1], // 이번 회차에서 선택하지 않는경우
                    Math.max(dp[i - 2] + wines[i], // 이번 회차, 이번 전전 회차에서 선택하는 경우
                            dp[i - 3] + wines[i - 1] + wines[i] // 이번 회차, 이번 전 회차에서 선택하는 경우
                    )
            );
        }

        System.out.println(dp[wines.length - 1]);
    }

    static void bindWines(BufferedReader br) throws IOException {
        for (int i = 0; i < wines.length; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
    }
}
