package baekjoon.sort;

import java.util.*;

public class SortingCoordinate {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] beforeArray = new int[N][2];
        for (int i = 0; i < N; i++) {
            beforeArray[i][0] = in.nextInt();
            beforeArray[i][1] = in.nextInt();
        }

        int[][] tempArray = new int[N][2];

        for (int i = 0; i < N; i++) {
            int min = 100002;
            int minIndex = 0;
            for (int j = 0; j < N; j++) {
                if (beforeArray[j][0] < min) {
                    min = beforeArray[j][0];
                    minIndex = j;
                    continue;
                }
            }

            tempArray[i][0] = beforeArray[minIndex][0];
            tempArray[i][1] = beforeArray[minIndex][1];

            beforeArray[minIndex][0] = 100001;
            beforeArray[minIndex][1] = 100001;
        }

        for (int i = 0; i < N - 1; i++) {
            boolean isChange = false;
            if (tempArray[i][0] == tempArray[i + 1][0]) {
                if (tempArray[i][1] > tempArray[i + 1][1]) {
                    isChange = true;
                }
            }

            if (isChange) {
                int x = tempArray[i][0];
                int y = tempArray[i][1];

                tempArray[i][0] = tempArray[i + 1][0];
                tempArray[i][1] = tempArray[i + 1][1];

                tempArray[i + 1][0] = x;
                tempArray[i + 1][1] = y;
            }
        }

        for (int[] ints : tempArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
