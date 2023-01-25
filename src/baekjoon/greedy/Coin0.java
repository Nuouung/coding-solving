package baekjoon.greedy;

import java.util.Scanner;

public class Coin0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int total = in.nextInt();

        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = in.nextInt();
        }

        int result = 0;
        for (int coin : coins) {
            while (total - coin >= 0) {
                result++;
                total = total - coin;
            }

            if (total == 0) break;
        }

        System.out.println(result);
    }
}
