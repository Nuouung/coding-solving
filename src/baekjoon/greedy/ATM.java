package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] atmLine = new int[N];
        for (int i = 0; i < N; i++) {
            atmLine[i] = in.nextInt();
        }

        Arrays.sort(atmLine);

        int k = atmLine.length;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = result + atmLine[i] * (k - i);
        }

        System.out.println(result);
    }
}
