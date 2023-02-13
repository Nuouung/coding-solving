package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GettingPrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = getNumberArray(br.readLine().split(" "));
        boolean[] primeNumbers = sieve(numberArray[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = numberArray[0]; i <= numberArray[1]; i++) {
            if (primeNumbers[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int[] getNumberArray(String[] sArray) {
        int[] numberArray = new int[sArray.length];

        for (int i = 0; i < sArray.length; i++) {
            numberArray[i] = Integer.parseInt(sArray[i]);
        }

        return numberArray;
    }

    static boolean[] sieve(int max) {
        boolean[] primeNumbers = new boolean[max + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i < primeNumbers.length; i++) {
            if (primeNumbers[i]) {
                for (int temp = i + i; temp < primeNumbers.length; temp = temp + i) {
                    primeNumbers[temp] = false;
                }
            }
        }

        return primeNumbers;
    }
}
