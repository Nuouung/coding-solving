package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorization {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                sb.append(i).append("\n");
                number = number / i;
            }
        }

        System.out.println(sb);
    }
}
