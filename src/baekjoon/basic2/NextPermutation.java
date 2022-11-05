package baekjoon.basic2;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String[] array = in.nextLine().split(" ");

        int index1 = N - 1;
        while (Integer.parseInt(array[index1 - 1]) >= Integer.parseInt(array[index1])) {
            if (index1 == 1) {
                break;
            }
            index1--;
        }

        if (index1 == 1) {
            System.out.println(-1);
            return;
        }

        int index2 = N - 1;
        while (Integer.parseInt(array[index1 - 1]) >= Integer.parseInt(array[index2])) {
            index2--;
        }

        String swap = array[index1 - 1];
        array[index1 - 1] = array[index2];
        array[index2] = swap;

        for (int i = 0; i < index1; i++) {
            System.out.print(array[i] + " ");
            array[i] = "-1";
        }

        Arrays.sort(array);
        for (int i = index1; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
