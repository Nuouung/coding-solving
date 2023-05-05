package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfPartialSequence {

    static int sum;
    static int count;

    static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sum = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] sArray = br.readLine().split(" ");
        array = new long[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            array[i] = Integer.parseInt(sArray[i]);
        }

        recursion(-1, 0, 0);
        System.out.println(count);
    }

    public static void recursion(int start, long currentSum, int depth) {
        if (depth > array.length) return;

        if (depth > 0) {
            if (currentSum == sum) {
                count++;
            }
        }

        for (int i = start + 1; i < array.length; i++) {
            recursion(i, currentSum + array[i], depth + 1);
        }
    }
}
