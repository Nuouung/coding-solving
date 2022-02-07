package baekjoon.sort;

import java.util.Scanner;

public class NumberSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] targetArray = new int[N];
        for (int i = 0; i < N; i++) {
            targetArray[i] = in.nextInt();
        }

        // 쌩으로 정렬 해보기
        // targetArray = justMyThoughtArray(targetArray);

        // 거품 정렬
        // bubbleSort(targetArray);

        // 선택 정렬
        // selectionSort(targetArray);

        // 삽입 정렬
        // insertionSort(targetArray);

        for (int i : targetArray) {
            System.out.println(i);
        }

    }

    public static int[] justMyThoughtArray(int[] targetArray) {
        int[] sortedArray = new int[targetArray.length];
        int count = 0;
        while (count < targetArray.length) {
            count++;

            int bigOne = 0;
            int index = 0;
            for (int i = 0; i < targetArray.length; i++) {
                if (targetArray[i] > bigOne) {
                    index = i;
                    bigOne = targetArray[i];
                }
            }

            targetArray[index] = -1;
            sortedArray[targetArray.length - count] = bigOne;
        }
        return sortedArray;
    }

    public static void bubbleSort(int[] targetArray) {

        int endPoint = targetArray.length;
        while (endPoint > 1) {

            for (int i = 0; i < endPoint - 1; i++) {
                if (targetArray[i] > targetArray[i + 1]) {
                    // swap
                    int temp = targetArray[i];
                    targetArray[i] = targetArray[i + 1];
                    targetArray[i + 1] = temp;
                }
            }
            endPoint--;

        }
    }

    public static void selectionSort(int[] targetArray) {

        int startPoint = 0;
        while (startPoint != targetArray.length - 1) {

            int index = startPoint;
            for (int i = startPoint; i < targetArray.length; i++) {
                if (targetArray[i] < targetArray[index]) {
                    index = i;
                }
            }

            // swap
            int temp = targetArray[startPoint];
            targetArray[startPoint] = targetArray[index];
            targetArray[index] = temp;

            startPoint++;
        }
    }

    public static void insertionSort(int[] targetArray) {

        for (int i = 1; i < targetArray.length; i++) {

            int index = i;
            int targetNumber = targetArray[i];
            while (index > 0 && targetArray[index - 1] > targetNumber) {
                targetArray[index] = targetArray[index - 1];
                index--;
            }

            targetArray[index] = targetNumber;
        }

    }
}
