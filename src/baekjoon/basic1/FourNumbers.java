package baekjoon.basic1;

import java.util.Scanner;

public class FourNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = Integer.toString(in.nextInt());
        String B = Integer.toString(in.nextInt());
        String C = Integer.toString(in.nextInt());
        String D = Integer.toString(in.nextInt());

        System.out.println(Long.parseLong(A + B) + Long.parseLong(C + D));
    }
}
