package baekjoon.basicmath2;

import java.util.Scanner;

public class BertrandPostulate {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            System.out.println(eratosthenesSieve(n));
        }

    }

    public static int eratosthenesSieve (int n) {

        int[] sieve = new int[2 * n + 1];

        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = i;
        }

        for (int i = 2; i < sieve.length; i++) {

            if (sieve[i] == 0) continue;

            for (int j = 2 * i; j < sieve.length; j += i) {
                sieve[j] = 0;
            }
        }

        int count = 0;
        for (int i = n + 1; i < sieve.length; i++) {
            if (sieve[i] > 1) count++;
        }

        return count;
    }

}
