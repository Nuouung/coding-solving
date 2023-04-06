package algorithm;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        s.sort(new int[]{2, 3, 4, 1});
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    targetIndex = j;
                }
            }

            int swapValue = array[i];
            array[i] = min;
            array[targetIndex] = swapValue;
        }
    }
}
