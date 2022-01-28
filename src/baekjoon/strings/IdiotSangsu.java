package baekjoon.strings;

import java.util.Scanner;

public class IdiotSangsu {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numberA = in.nextInt();
        int numberB = in.nextInt();

        int tempA = numberA;
        int tempB = numberB;

        String bigOne = "";
        while (tempA != 0 || tempB != 0) {
            if (tempA % 10 > tempB % 10) {
                bigOne = "A";
                break;
            } else if (tempB % 10 > tempA % 10) {
                bigOne = "B";
                break;
            }

            tempA = tempA / 10;
            tempB = tempB / 10;
        }

        String answer = String.valueOf((bigOne.equals("A"))? numberA : numberB);

        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }

    }

}
