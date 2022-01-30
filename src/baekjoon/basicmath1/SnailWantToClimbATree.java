package baekjoon.basicmath1;

import java.util.Scanner;

public class SnailWantToClimbATree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int up = in.nextInt();
        int down = in.nextInt();
        int height = in.nextInt();

        int day = ((height - up) / (up - down)) + 1;

        if ((height - up) % (up - down) != 0) {
            day++;
        } 

        System.out.println(day);
    }
}
