package baekjoon.basicmath1;

import java.util.Scanner;

public class HotelAcm {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int height = in.nextInt();
            int weight = in.nextInt();
            int standBy = in.nextInt();

            int x = 1;
            while (standBy >= height) {
                standBy -= height;
                x++;
            }

            if (x < 10) {
                System.out.println(standBy + "0" + x);
            } else {
                System.out.println(standBy + "" + x);
            }
        }

    }

}
