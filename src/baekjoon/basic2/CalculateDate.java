package baekjoon.basic2;

import java.util.Scanner;

public class CalculateDate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        int E = Integer.parseInt(string.split(" ")[0]);
        int S = Integer.parseInt(string.split(" ")[1]);
        int M = Integer.parseInt(string.split(" ")[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int count = 1;

        while (!(e == E && s == S && m == M)) {
            e++;
            s++;
            m++;

            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;

            count++;
        }

        System.out.println(count);
    }
}
