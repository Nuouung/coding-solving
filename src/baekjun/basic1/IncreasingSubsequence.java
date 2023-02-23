package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSubsequence {

    static long[] results;
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        init(n, br.readLine().split(" "));

        results[0] = 1;

        for (int i = 1; i < n; i++) {
            results[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && results[i] <= results[j])
                    results[i] = results[j] + 1;
            }
        }

        long result = 0;
        for (long r : results) {
            if (r > result) result = r;
        }

        System.out.println(result);
    }

    private static void init(int n, String[] s) {
        results = new long[n];
        numbers = new long[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
    }
}
