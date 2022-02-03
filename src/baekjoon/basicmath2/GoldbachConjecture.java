package baekjoon.basicmath2;

import java.util.Scanner;

public class GoldbachConjecture {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int n = in.nextInt();

            int[] primeNumbers = eratosthenesSieve(n);

            int middle = n / 2;
            boolean isOver = false;
            for (int j = middle; j > 1; j--) {
                if (isOver) break;

                if (primeNumbers[j] != 0) {
                    for (int k = j; k < primeNumbers.length; k++) {
                        if (primeNumbers[k] != 0 && primeNumbers[j] + primeNumbers[k] == n) {
                            System.out.println(primeNumbers[j] + " " + primeNumbers[k]);
                            isOver = true;
                            break;
                        }
                    }
                }
            }
        }

    }

    public static int[] eratosthenesSieve(int n) {
        int[] sieve = new int[n + 1];

        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = i;
        }

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i] == 0) continue;

            for (int j = 2 * i; j < sieve.length; j += i) {
                sieve[j] = 0;
            }
        }

        return sieve;
    }

}
