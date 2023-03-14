package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteSuire1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder targetNumber = new StringBuilder(br.readLine());

        long result = 0;
        while (Integer.parseInt(targetNumber.toString()) > 0) {
            result += targetNumber.length();
            targetNumber.replace(0, targetNumber.length(), Integer.toString(Integer.parseInt(targetNumber.toString()) - 1));
        }

        System.out.println(result);
    }
}
