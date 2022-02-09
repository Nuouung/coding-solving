package baekjoon.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortInside {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String s = Integer.toString(N);

        Integer[] arr = new Integer[s.length()];

        int i = 0;
        while (N != 0) {
            arr[i] = N % 10;
            N = N / 10;
            i++;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer integer : arr) {
            System.out.print(integer);
        }

    }

}
