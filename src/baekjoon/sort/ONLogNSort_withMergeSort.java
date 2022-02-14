package baekjoon.sort;

import java.io.*;
import java.util.Scanner;


public class ONLogNSort_withMergeSort {

    public static void main(String[] args) throws IOException {

//        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int N = in.nextInt();
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
//            answer[i] = in.nextInt();
            answer[i] = Integer.parseInt(br.readLine());
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}

class MergeSort {

    public void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int[] temp, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, temp, start, middle);
            mergeSort(array, temp, middle + 1, end);
            merge(array, temp, start, middle, end);
        }
    }

    // start = 0, end = 1, middle = 0
    public void merge(int[] array, int[] temp, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }

        int partA = start;
        int partB = middle + 1;
        int index = start;

        // partA가 middle에 도달하거나, partB가 end에 도달하면 반복문 중지
        // partA > middle or partB > end
        // while (partA <= middle and partB <= end)
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

        // 다 돌고 나왔는데도 앞쪽에 데이터가 남아 있을 경우
        for (int i = 0; i <= middle - partA; i++) {
            array[index + i] = temp[partA + i];
        }

        // 뒤에 남아 있을 수 있는 데이터는 이미 array에 반영되어 있다. (temp의 뒷쪽 배열이 array의 뒷쪽 배열이기 때문이다)
    }

}