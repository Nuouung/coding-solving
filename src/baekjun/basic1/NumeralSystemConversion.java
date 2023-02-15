package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumeralSystemConversion {

    static char[] extraLetters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setExtraLetters();

        String[] s = br.readLine().split(" ");
        System.out.println(solution(Long.parseLong(s[0]), Integer.parseInt(s[1])));
    }

    static String solution(long decimal, int convertNumber) {
        if (decimal == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            sb.append(getConvertedNumber(decimal, convertNumber));
            decimal = decimal / convertNumber;
        }

        return sb.reverse().toString();
    }

    static char getConvertedNumber(long decimal, int convertNumber) {
        if (decimal % convertNumber < 10)
            return (char) (decimal % convertNumber + '0');

        return extraLetters[(int) (decimal % convertNumber)];
    }

    static void setExtraLetters() {
        extraLetters = new char[36];

        // A 65, Z 90 (65가 10번째 배열에 들어가고, 90번째가 35번째 배열에 들어가는 식으로)
        for (int i = 10; i < extraLetters.length; i++) {
            int charName = i + 55; // i = 10 -> charName = 65 (A)
            extraLetters[i] = (char) charName;
        }
    }
}
