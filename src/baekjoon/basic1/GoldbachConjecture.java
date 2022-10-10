package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x;
        StringBuilder sb = new StringBuilder();
        while ((x = Integer.parseInt(br.readLine())) != 0) {
            boolean checkA = false;

            for (int i = 1; i < x / 2; i++) {
                int smallOdd = (2 * i) + 1;
                if (!isPrime(smallOdd)) continue;
                if (smallOdd > x / 2) {
                    sb.append("Goldbach's conjecture is wrong.").append("\n");
                    break;
                }

                boolean checkB = false;

                for (int j = x / 2; j > i + 1; j--) {
                    int bigOdd = (2 * j) - 1;
                    if (!isPrime(bigOdd)) continue;

                    if (smallOdd + bigOdd == x) {
                        sb.append(x)
                                .append(" = ")
                                .append(smallOdd)
                                .append(" + ")
                                .append(bigOdd)
                                .append("\n");
                        checkB = true;
                        break;
                    } else if (smallOdd + bigOdd > x) {
                        break;
                    }
                }

                if (checkB) {
                    checkA = true;
                    break;
                }
            }

            if (!checkA) sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
