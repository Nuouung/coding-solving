package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldbachPartition {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        getPrimeArray();

        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            int result = getGoldbachPartition(Integer.parseInt(br.readLine()));
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static int getGoldbachPartition(int n) {
        int result = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isGoldbach(n, i)) result++;
        }

        return result;
    }

    static boolean isGoldbach(int n, int left) {
        return isPrime[left] && isPrime[n - left];
    }

    static void getPrimeArray() {
        isPrime = new boolean[1_000_001];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
