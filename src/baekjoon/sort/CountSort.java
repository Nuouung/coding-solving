package baekjoon.sort;

import java.io.*;

public class CountSort {

    // count sort : 배열의 가장 큰 숫자가 그렇게 크지 않다면 효율적인 정렬 방법
    // 시간복잡도 - O(n + k) 라고 한다. (k = 배열 내의 가장 큰 수)
    // 최선의 경우(k가 n보다 작은 경우) O(n)의 매우 효율적인 정렬 방법
    // 최악의 경우 무한의 시간복잡도를 가질 수 있다고 하네. (말 그대로 진짜 최악인 경우네..)

    public static void main(String[] args) throws IOException {

        // 효율성을 위해 Scanner 대신 BufferedReader 사용
        // 효율성을 위해 println 대신 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 배열의 가장 큰 수 검출 - O(n)?
        int max = 0;
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }

        // countArray에 값 할당 - O(n)?
        int[] countArray = new int[max + 1];
        for (int a : array) {
            countArray[a]++;
        }

        // 배열 정렬 - O(n)?
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[index] = i;
                index++;
                countArray[i]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : array) {
            sb.append(a).append("\n");
        }

        // O(n)이 세개 있었으니 결과는 O(3n)인가????
        bw.write(sb.toString());
        bw.flush();
    }
}
