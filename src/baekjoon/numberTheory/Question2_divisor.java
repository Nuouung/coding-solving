package baekjoon.numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class Question2_divisor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(array);

        int result = 0;
        if (N == 1) {
            result = array[0] * 2;
        } else {
            result = array[0] * array[N - 1];
        }


        System.out.println(result);
    }
}
