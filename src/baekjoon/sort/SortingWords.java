package baekjoon.sort;

import java.util.Scanner;

public class SortingWords {

    public static void main(String[] args) {
        String[] box = initData();
        insertionSort(box);

        for (String s : box) {
            System.out.println(s);
        }
    }

    private static String[] initData() {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String[] box = new String[N];

        for (int i = 0; i < N; i++) {
            box[i] = in.next();
        }

        in.close();

        return box;
    }

    private static void insertionSort(String[] targetArray) {
        insertionSort(targetArray, 0);
    }

    private static void insertionSort(String[] targetArray, int start) {
        if (start < targetArray.length - 1) {
            int targetNumber = targetArray[start + 1].length();
            String target = targetArray[start + 1];
            int k = start;

            while (k >= 0 && targetNumber < targetArray[k].length()) {
                targetArray[k + 1] = targetArray[k];
                k--;
            }

            targetArray[k + 1] = target;

            insertionSort(targetArray, start + 1);
        }
    }

}
