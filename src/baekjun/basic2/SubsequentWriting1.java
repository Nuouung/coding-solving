package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsequentWriting1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        int plus = 1;
        int carry = 10;

        for (int i = 1; i <= n; i++) {
            // 자리수 바뀌는 조건 10 100 1000 10000 100000 ...
            if (i % carry == 0) {
                plus++;
                carry = carry * 10;
            }

            result += plus;
        }

        System.out.println(result);
    }
}
