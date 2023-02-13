package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingPrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numberArray = getNumberArray(br.readLine().split(" "));

        Arrays.sort(numberArray);
        boolean[] compositeNumbers = sieve(numberArray[n - 1]);

        int result = 0;
        for (int number : numberArray) {
            if (!compositeNumbers[number]) result++;
        }

        System.out.println(result);
    }

    static int[] getNumberArray(String[] sArray) {
        int[] numberArray = new int[sArray.length];

        for (int i = 0; i < sArray.length; i++) {
            numberArray[i] = Integer.parseInt(sArray[i]);
        }

        return numberArray;
    }

    static boolean[] sieve(int biggest) {
        // true는 합성수, false는 소수
        boolean[] compositeNumbers = new boolean[biggest + 1];
        compositeNumbers[0] = true;
        compositeNumbers[1] = true;

        for (int i = 2; i < compositeNumbers.length; i++) {
            // 소수라면
            if (!compositeNumbers[i]) {
                int temp = i + i;
                while (temp <= compositeNumbers.length - 1) {
                    compositeNumbers[temp] = true;
                    temp = temp + i;
                }
            }
        }

        return compositeNumbers;
    }
}
