package baekjoon.basicmath2;

import java.util.Scanner;

public class EratosthenesSieve {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        eratosthenesSieve(M, N);

    }

    public static void eratosthenesSieve(int M, int N) {
        int[] sieve = new int[N + 1];

        for (int i = 2; i < N + 1; i++) {
            sieve[i] = i;
        }

        for (int i = 2; i < N + 1; i++) {
            if (sieve[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j < N + 1; j += i) {
                sieve[j] = 0;
            }
        }

        for (int value : sieve) {
            if (value >= M) {
                System.out.println(value);
            }
        }
    }

}
