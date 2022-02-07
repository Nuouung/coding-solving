package baekjoon.bruteForce;

import java.util.Scanner;

public class SyomTheMovieDirector {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        int i = 0;
        while (count != n) {
            i++;
            String temp = Integer.toString(i);
            for (int j = 0; j < temp.length() - 2; j++) {
                if (temp.charAt(j) == '6' && temp.charAt(j + 1) == '6' && temp.charAt(j + 2) == '6') {
                    count++;
                    break;
                }
            }
        }
        System.out.println(i);
    }

}
