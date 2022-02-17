package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Statics_failed2 {

    public static void main(String[] args) throws IOException {

        // 효율성을 위해 Scanner 대신 BufferedReader 사용
        // 효율성을 위해 println 대신 BufferedWriter 사용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner in = new Scanner(System.in);

//        int N = Integer.parseInt(br.readLine());
        int N = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
//            array[i] = Integer.parseInt(br.readLine());
            array[i] = in.nextInt();
        }

        // A : N개의 수들의 합을 N으로 나눈 값
        // B : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        // C : N개의 수들 중 가장 많이 나타나는 값
        // D : N개의 수들 중 최댓값과 최솟값의 차이

        StringBuilder sb = new StringBuilder();

        // A
        sb.append(calculateA(array)).append("\n");

        // B
        Arrays.sort(array);
        sb.append(array[array.length / 2]).append("\n");

        // C
        // 범위는 -4000 ~ 4000이다
        // 가능한 값은 8001개 (4000 -(-4000) + 1)
        int[] scope = new int[8001];
        for (int a : array) {
            scope[a + 4000]++;
        }

        int maxOfScope = 0;
        int maxNumber = 0;
        for (int i = 0; i < scope.length; i++) {
            if (scope[i] > maxNumber) {
                maxOfScope = i;
                maxNumber = scope[i];
            } else if (maxNumber != 0) {
                if (scope[i] == maxNumber) {
                    maxOfScope = i;
                    break;
                }

            }
        }

        sb.append(maxOfScope - 4000).append("\n");

        // D
        sb.append(array[array.length - 1] - array[0]);

        System.out.println(sb);
//        bw.write(String.valueOf(sb));
//        bw.flush();

    }

    private static int calculateA(int[] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }

        return (int)Math.round((double) sum / array.length);
    }

}
