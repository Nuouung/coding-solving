package baekjoon.strings;

import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String numbers = in.next();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int next = numbers.charAt(i) - 48;
            sum += next;
        }
        System.out.println(sum);
    }

}
