package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextPermutation {

    // https://dding9code.tistory.com/8

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] s = br.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++)
            array[i] = Integer.parseInt(s[i]);

        int step1 = doStep1(array);
        if (step1 == -1) {
            System.out.println(-1);
            System.exit(0);
        }

        int step2 = doStep2(array, step1);

        doStep3(array, step1, step2);

        doStep4(array, step1);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void doStep4(int[] array, int step1) {
        int[] temp = new int[array.length - step1 - 1];
        for (int i = array.length - 1; i > step1; i--) {
            temp[Math.abs(i - (array.length - 1))] = array[i];
        }

        for (int i = step1 + 1; i < array.length; i++) {
            array[i] = temp[i - (step1 + 1)];
        }
    }

    private static void doStep3(int[] array, int step1, int step2) {
        int temp = array[step1];
        array[step1] = array[step2];
        array[step2] = temp;
    }

    private static int doStep1(int[] array) {
        int right = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < right) return i;

            right = array[i];
        }

        return -1;
    }

    private static int doStep2(int[] array, int step1) {
        for (int i = array.length - 1; i > step1; i--) {
            if (array[i] > array[step1]) return i;
        }

        return -1;
    }
}
