package baekjoon.basicmath1;

import java.util.Scanner;

public class FindFraction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();

        int n = 1;
        int sum = n;
        while (X > sum) {
            n++;
            sum += n;
        }

        int index = X - (sum - n);
        if (n % 2 == 1) {
            System.out.println((n - index + 1) + "/" + index);
        } else {
            System.out.println(index + "/" + (n - index + 1));
        }
    }

}
