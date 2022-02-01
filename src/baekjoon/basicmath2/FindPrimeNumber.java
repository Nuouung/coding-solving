package baekjoon.basicmath2;

import java.util.Scanner;

public class FindPrimeNumber {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int count = 0;
        for (int i = 0; i < N; i++) {
            int candidate = in.nextInt();

            boolean check = true;
            for (int j = 2; j < candidate; j++) {
                if (candidate % j == 0) {
                    check = false;
                }
            }

            if (check && candidate != 1) {
                count++;
            }

        }
        System.out.println(count);
    }

}
