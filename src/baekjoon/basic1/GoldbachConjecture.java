package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x;

        int[] primeArray = getEratosthenesSieve(1_000_000);
        StringBuilder sb = new StringBuilder();
        while ((x = Integer.parseInt(br.readLine())) != 0) {
            boolean isYes = false;
            for (int i = 2; i < x / 2; i++) {
                if (primeArray[i - 1] != 0 && primeArray[x - i - 1] != 0) {
                    System.out.println(x + " = " + i + " + " + (x - i));
                    isYes = true;
                    break;
                }
            }

            if (!isYes) System.out.println("Goldbach's conjecture is wrong.");
        }

    }

    private static int[] getEratosthenesSieve(int max) {
        int[] array = new int[max];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        array[0] = 0; // 1은 소수가 아니므로 0 처리

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number != 0) {
                int x = 2;
                while (x * number <= max) {
                    array[(number * x) - 1] = 0;
                    x++;
                }
            }
        }

        return array;
    }
}
