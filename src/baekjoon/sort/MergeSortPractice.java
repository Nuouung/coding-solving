package baekjoon.sort;

public class MergeSortPractice {

    public static void main(String[] args) {
        int[] array = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        mergeSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, temp, start, middle);
            mergeSort(array, temp, middle + 1, end);
            merge(array, temp, start, middle, end);
        }
    }

    private static void merge(int[] array, int[] temp, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }

        int partA = start;
        int partB = middle + 1;
        int index = start;

        while (partA <= middle && partB <= end) {
            if (temp[partA] <= temp[partB]) {
                array[index] = temp[partA];
                partA++;
            } else {
                array[index] = temp[partB];
                partB++;
            }
            index++;
        }

        for (int i = 0; i <= middle - partA; i++) {
            array[index + i] = temp[partA + i];
        }
    }
}
