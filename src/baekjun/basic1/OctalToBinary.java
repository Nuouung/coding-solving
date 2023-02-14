package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OctalToBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(toBinary(br.readLine()));
    }

    static String toBinary(String octal) {
        if (octal.equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        // 첫번째 자리
        sb.append(
                getTempBinary(octal, 0).reverse());

        // 나머지
        for (int i = 1; i < octal.length(); i++) {
            StringBuilder temp = getTempBinary(octal, i);
            while (temp.length() < 3) {
                temp.append("0");
            }

            sb.append(temp.reverse());
        }

        return sb.toString();
    }

    private static StringBuilder getTempBinary(String octal, int i) {
        StringBuilder temp = new StringBuilder();
        int current = Character.getNumericValue(octal.charAt(i));

        while (current > 0) {
            temp.append(current % 2);
            current = current / 2;
        }
        return temp;
    }
}
