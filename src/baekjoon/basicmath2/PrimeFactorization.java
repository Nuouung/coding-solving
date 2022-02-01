package baekjoon.basicmath2;

import java.util.Scanner;

public class PrimeFactorization {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        while (N > 1) {
            for (int i = 2; i <= N; i++) {
                boolean check = true;

                if (i != 2) {
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            check = false;
                            break;
                        }
                    }
                }

                if (check && N % i == 0) {
                    N = N / i;
                    System.out.println(i);
                    break;
                }
            }
        }

    }

}
