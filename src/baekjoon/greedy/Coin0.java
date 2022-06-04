package baekjoon.greedy;

import java.util.Scanner;

public class Coin0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String index = in.nextLine();
        int N = Integer.parseInt(index.split(" ")[0]);
        int K = Integer.parseInt(index.split(" ")[1]);

        int[] coinArray = new int[N];
        for (int i = 0; i < N; i++) {
            coinArray[i] = in.nextInt();
        }

        int count = 0;
        while (K > 0) {
            int maxCoin = 0;
            for (int i = coinArray.length - 1; i >= 0; i--) {
                if (coinArray[i] <= K) {
                    maxCoin = coinArray[i];
                    break;
                }
            }

            while (maxCoin <= K) {
                K -= maxCoin;
                count++;
            }
        }

        System.out.println(count);
    }
}
