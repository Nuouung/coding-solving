package baekjoon.bruteForce;

import java.util.Scanner;

public class FatBoy {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 초기화
        int N = in.nextInt();
        int[] weight = new int[N];
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = in.nextInt();
            height[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {

            int count = 1;
            for (int j = 0; j < N; j++) {

                if (i == j) continue;

                if (weight[i] < weight[j] && height[i] < height[j]) {
                    count++;
                }

            }


            System.out.print(count + " ");

        }

    }

}
