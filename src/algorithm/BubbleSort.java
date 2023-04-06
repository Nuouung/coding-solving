package algorithm;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        b.sort(new int[]{2, 3, 4, 1});
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swapValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swapValue;
                }
            }
        }
    }
}
