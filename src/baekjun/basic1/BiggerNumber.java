package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BiggerNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] biggerNumbers = new int[Integer.parseInt(br.readLine())];
        int[] numbers = getNumbers(br);

        setBiggerNumbers(biggerNumbers, numbers);
        for (int biggerNumber : biggerNumbers) {
            sb.append(biggerNumber).append(" ");
        }

        System.out.println(sb);
    }

    private static void setBiggerNumbers(int[] biggerNumbers, int[] numbers) {
        biggerNumbers[biggerNumbers.length - 1] = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                biggerNumbers[i] = numbers[i + 1];
                continue;
            }

            int j = i + 1;
            while (true) {
                if (biggerNumbers[j] == -1) {
                    biggerNumbers[i] = -1;
                    break;
                }

                if (numbers[i] < biggerNumbers[j]) {
                    biggerNumbers[i] = biggerNumbers[j];
                    break;
                }

                j++;
            }
        }
    }

    static int[] getNumbers(BufferedReader br) throws IOException {
        return Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
