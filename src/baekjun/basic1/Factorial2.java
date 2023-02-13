package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factorial2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String factorial = getFactorial(Integer.parseInt(br.readLine()));

        int result = 0;
        for (int i = factorial.length() - 1; i >= 0; i--) {
            if (factorial.charAt(i) != '0') break;

            result++;
        }

        System.out.println(result);
    }

    static String getFactorial(int n) {
        if (n == 0) return "1";

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return String.valueOf(result);
    }
}
