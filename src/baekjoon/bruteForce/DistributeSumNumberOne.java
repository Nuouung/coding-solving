package baekjoon.bruteForce;

import java.util.Scanner;

public class DistributeSumNumberOne {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        boolean check = true;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            int sum = i;
            while (temp != 0) {
                sum += temp % 10;
                temp = temp / 10;
            }

            if (sum == N) {
                check = false;
                System.out.println(i);
                break;
            }
        }

        if (check) {
            System.out.println(0);
        }

    }

}
