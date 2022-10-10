package baekjoon.basic1;

import java.util.Scanner;

public class GcdAndLcm {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while (N-- > 0) {
            String s = in.nextLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);

            System.out.println((a * b) / gcd(a, b));
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
