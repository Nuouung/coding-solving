package programmers;

import java.util.Arrays;

public class GetMean {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};

        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        System.out.println((double) sum / arr.length);
    }
}
