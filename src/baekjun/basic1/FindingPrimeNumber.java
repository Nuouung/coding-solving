package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingPrimeNumber {

    static boolean[] numbers;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()) + 1;
        numbers = new boolean[n];

        sieveOfEratosThenes();

        int result = 0;
        String[] sArray = br.readLine().split(" ");
        for (String s : sArray) {
            int i = Integer.parseInt(s);

            if (!numbers[i]) result++;
        }

        System.out.println(result);
    }

    static void sieveOfEratosThenes() {
        numbers[0] = true;
        numbers[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!numbers[i]) {
                for (int j = i * i; j <= n; j += i) numbers[j] = true;
            }
        }
    }
}
