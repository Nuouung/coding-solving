package baekjoon.recursion;

public class MergeSortPractice {

    public static void main(String[] args) {

        int[] array = {19,2,30,20,3,5,1,8,90,3,87,39,20};
        MergeSortProvider.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static class MergeSortProvider {

        public static void sort(int[] targetArray) {
            divideAndMerge(targetArray, new int[targetArray.length], 0, targetArray.length - 1);
        }

        private static void divideAndMerge(int[] targetArray, int[] tempArray, int start, int end) {

            int middle = (start + end) / 2;
            if (start >= end) return;

            divideAndMerge(targetArray, tempArray, start, middle); // 전반부 분할 + 합병
            divideAndMerge(targetArray, tempArray, middle + 1, end); // 후반부 분할 + 합병
            merge(targetArray, tempArray, start, middle, end); // 합병
        }

        private static void merge(int[] targetArray, int[] tempArray, int start, int middle, int end) {
            for (int i = start; i <= end; i++) {
                tempArray[i] = targetArray[i];
            }

            int pointA = start;
            int pointB = middle + 1;
            int index = start;

            while (pointA <= middle && pointB <= end) {
                if (tempArray[pointA] < tempArray[pointB]) {
                    targetArray[index] = tempArray[pointA];
                    pointA++;
                } else {
                    targetArray[index] = tempArray[pointB];
                    pointB++;
                }

                index++;
            }

            if (pointA <= middle) {
                while (index <= end) {
                    targetArray[index] = tempArray[pointA];
                    pointA++;
                    index++;
                }
            }
        }
    }
}
