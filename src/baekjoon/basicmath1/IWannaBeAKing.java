package baekjoon.basicmath1;

import java.util.Scanner;

public class IWannaBeAKing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] apart = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apart[i][1] = 1;
            apart[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int floor = in.nextInt();
            int ho = in.nextInt();
            System.out.println(apart[floor][ho]);
        }

    }

}
