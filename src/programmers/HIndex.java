package programmers;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        HIndex h = new HIndex();
        System.out.println(h.solution(new int[]{3, 0, 6, 1, 5}));
    }

    public int solution(int[] citations) {
        int answer = 0;

        mergeSort(citations, 0, citations.length - 1);
        for (int i = 0; i < citations.length; i++) {
            int rightPaperNumber = citations.length - i;
            if (rightPaperNumber <= citations[i]) {
                answer = rightPaperNumber;
                break;
            }
        }
        return answer;
    }

    private void mergeSort(int[] array, int start, int end) {
        // 0 0 0 0 0 0
        // 0 1 2 3 4 5
        if (start >= end) {
            return;
        }

        int middle = (end + start) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);

        int i1 = start;
        int i2 = middle + 1;
        int current = start;
        int[] tempArray = Arrays.copyOf(array, array.length);
        while (i1 <= middle && i2 <= end) {
            if (tempArray[i1] < tempArray[i2]) {
                array[current] = tempArray[i1];
                i1++;
            } else if (tempArray[i2] <= tempArray[i1]) {
                array[current] = tempArray[i2];
                i2++;
            }

            current++;
        }

        while (i1 <= middle) {
            array[current] = tempArray[i1];
            i1++;
            current++;
        }
    }
}
