package programmers;

public class MergeSortPractice {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1};
        mergeSort(array);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, end, middle);
    }

    private static void merge(int[] array, int start, int end, int middle) {
        int indexA = start;
        int indexB = middle + 1;
        int index = start;
        int[] temp = array.clone();

        while (indexA <= middle && indexB <= end) {
            if (temp[indexA] >= temp[indexB]) {
                array[index] = temp[indexB];
                indexB++;
            } else {
                array[index] = temp[indexA];
                indexA++;
            }

            index++;
        }

        if (indexA <= middle) {
            while (index <= end) {
                array[index] = temp[indexA];

                indexA++;
                index++;
            }
        }
    }
}
