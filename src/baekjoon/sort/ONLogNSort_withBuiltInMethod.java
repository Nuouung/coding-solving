package baekjoon.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ONLogNSort_withBuiltInMethod {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] targetArray = new int[N];
        for (int i = 0; i < N; i++) {
            targetArray[i] = in.nextInt();
        }

        Arrays.sort(targetArray);

        for (int i : targetArray) {
            System.out.println(i);
        }

    }

}
