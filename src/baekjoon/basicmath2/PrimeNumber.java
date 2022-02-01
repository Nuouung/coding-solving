package baekjoon.basicmath2;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N= in.nextInt();

        int sum = 0;
        int minPrimeNumber = N;
        for (int i = M; i <= N; i++) {

            if (i == 1) {
                continue;
            }

            boolean check = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = false;
                }
            }

            if (check) {
                sum += i;
                if (minPrimeNumber > i) {
                    minPrimeNumber = i;
                }

            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minPrimeNumber);
        }

    }

}
