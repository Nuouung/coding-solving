package baekjoon.basicmath2;

import java.util.Scanner;

public class EscapeFromRectangle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();

        int X = x;
        int Y = y;

        if (x > width / 2) {
            X = width - x;
        }

        if (y > height / 2) {
            Y = height - y;
        }

        if (X > Y) {
            System.out.println(Y);
        } else {
            System.out.println(X);
        }

    }

}
