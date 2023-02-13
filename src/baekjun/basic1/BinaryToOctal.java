package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryToOctal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        System.out.println(toOctal(binary));
    }

    static String toOctal(String binary) {
        StringBuilder sb = new StringBuilder();

        // 세 자리씩 끊어 한 자리만 남았을 경우
        if (binary.length() % 3 == 1) {
            sb.append(binary.charAt(0));
        }

        // 세 자리씩 끊어 두 자리만 남았을 경우
        if (binary.length() % 3 == 2) {
            sb.append(
                    Character.getNumericValue(binary.charAt(0)) * 2
                    + Character.getNumericValue(binary.charAt(1)));
        }

        // 나머지 경우
        for (int i = binary.length() % 3; i < binary.length(); i = i + 3) {
            sb.append(
                    Character.getNumericValue(binary.charAt(i)) * 4
                    + Character.getNumericValue(binary.charAt(i + 1)) * 2
                    + Character.getNumericValue(binary.charAt(i + 2)));
        }

        return sb.toString();
    }
}
