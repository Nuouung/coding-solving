package baekjoon.recursion;

import java.util.Scanner;

public class PrintStars {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                printStars(i, j, n);
            }
            System.out.println();
        }

    }

    public static void printStars(int i, int j, int n) {

        if ((i / n) % 3 == 1 && (j / n) % 3 == 1) {
            System.out.print(" ");
        } else {
            if (n / 3 == 0) {
                System.out.print("*");
            } else {
                printStars(i, j, n / 3);
            }
        }

    }


}
