package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getFactorial(Integer.parseInt(br.readLine())));
    }

    static long getFactorial(int n) {
        if (n == 0) return 1;

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
