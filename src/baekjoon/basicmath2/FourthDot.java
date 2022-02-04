package baekjoon.basicmath2;

import java.util.Scanner;

public class FourthDot {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int xA = in.nextInt();
        int yA = in.nextInt();

        int xB = in.nextInt();
        int yB = in.nextInt();

        int xC = in.nextInt();
        int yC = in.nextInt();

        int xD;
        int yD;

        if (xA == xB) {
            xD = xC;
        } else if (xA == xC) {
            xD = xB;
        } else {
            xD = xA;
        }

        if (yA == yB) {
            yD = yC;
        } else if (yA == yC) {
            yD = yB;
        } else {
            yD = yA;
        }

        System.out.println(xD + " " + yD);

    }

}
