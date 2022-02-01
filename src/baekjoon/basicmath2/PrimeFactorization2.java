package baekjoon.basicmath2;

import java.util.Scanner;

public class PrimeFactorization2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                N = N / i;
                System.out.println(i);
            }
        }

    }

}
