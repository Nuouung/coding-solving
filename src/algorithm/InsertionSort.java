package algorithm;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        i.sort(new int[]{4, 2, 3, 1});
    }

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pickValue = array[i];

            for (int j = i; j >= 0; j--) {
                if (j == 0 || array[j - 1] < pickValue) {
                    array[j] = pickValue;
                    break;
                }

                array[j] = array[j - 1];
            }
        }
    }
}
