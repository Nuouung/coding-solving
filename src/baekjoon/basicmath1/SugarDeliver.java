package baekjoon.basicmath1;

import java.util.Scanner;

public class SugarDeliver {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0;

        boolean check = true;
        boolean anotherCheck = true;
        while(check) {
            if (n == 0) {
                check = false;
                continue;
            }

            if (n % 5 == 0) {
                n -= 5;
                answer++;
            } else if (n < 3) {
                check = false;
                anotherCheck = false;
                System.out.println(-1);
            } else {
                n -= 3;
                answer++;
            }
        }

        if (anotherCheck) {
            System.out.println(answer);
        }

    }

}
