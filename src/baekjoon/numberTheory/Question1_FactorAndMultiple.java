package baekjoon.numberTheory;

import java.util.Scanner;

public class Question1_FactorAndMultiple {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            int A = Integer.parseInt(in.next());
            int B = Integer.parseInt(in.next());

            if (A == 0 && B == 0) break;

            if (A % B == 0) {
                System.out.println("multiple");
            } else if (B % A == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }

}
