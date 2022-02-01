package baekjoon.basicmath1;

import java.util.Scanner;

public class FlyMeToTheAlphaCentauri {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            long x = Long.getLong(in.next());
            long y = Long.getLong(in.next());

            long distance = y - x;
            long temp = distance;

            boolean canEscape = true;
            int k = 0;
            while(canEscape) {
                int squareRoot = (int) Math.sqrt(temp);
                if (Math.pow(squareRoot, 2) == temp) {
                    k = squareRoot;
                    canEscape = false;
                } else {
                    temp -= 1;
                }
            }

            System.out.println(k);

        }

    }

}
