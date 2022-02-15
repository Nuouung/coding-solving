package baekjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Statistics_failed {

    public static void main(String[] args) throws IOException {

        // 효율성을 위해 Scanner 대신 BufferedReader 사용
        // 효율성을 위해 println 대신 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = createArray(br, N);

        // A : N개의 수들의 합을 N으로 나눈 값
        // B : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        // C : N개의 수들 중 가장 많이 나타나는 값
        // D : N개의 수들 중 최댓값과 최솟값의 차이

        int min = 4000;
        int max = -4000;
        for (int a : array) {
            if (a > max) max = a;
            if (a < min) min = a;
        }

        CountSortManager cm = new CountSortManager();
        int[] countArray = cm.createCountArray(array, min, max);
        cm.sort(array, countArray, min);

        int A = calculateA(min, countArray, N);
        int B = calculateB(array);
        int C = calculateC(countArray, min);
        int D = max - min;

        StringBuilder sb = new StringBuilder();
        sb.append(A).append("\n")
                .append(B).append("\n")
                .append(C).append("\n")
                .append(D).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calculateA(int min, int[] countArray, int N) {
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            // 갯수 = countArray[i]
            // 값 = i + min;
            sum += countArray[i] * (i + min);
        }

        return (int) Math.round((double) sum / N);
    }

    private static int calculateB(int[] array) {
        int middle = array.length / 2;
        return array[middle];
    }

    private static int calculateC(int[] countArray, int min) {
        List<Integer> multiIndex = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > max) {
                max = i;
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == max) {
                multiIndex.add(i);
            }
        }

        int index = max;
        if (multiIndex.size() > 1) {
            index = multiIndex.get(1);
        }

        return index + min;
    }

    private static int[] createArray(BufferedReader br, int N) throws IOException {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        return array;
    }

}

class CountSortManager {

    public int[] createCountArray(int[] array, int min, int max) {
        int[] countArray = new int[max - min + 1];
        for (int a : array) {
            countArray[a - min]++;
        }
        return countArray;
    }

    public void sort(int[] array, int[] countArray, int min) {
        int[] copyOfCountArray = copyArray(countArray);

        int index = 0;
        for (int i = 0; i < copyOfCountArray.length; i++) {
            while (copyOfCountArray[i] > 0) {
                array[index] = i + min;
                index++;
                copyOfCountArray[i]--;
            }
        }
    }

    private static int[] copyArray(int[] countArray) {
        int[] copyArray = new int[countArray.length];

        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = countArray[i];
        }

        return copyArray;
    }

}