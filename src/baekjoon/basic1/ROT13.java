package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

    private static final int SMALL_Z = 122;
    private static final int CAPITAL_Z = 90;
    private static final int MOVE = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isCapitalAlphabet(c)) {
                makeROT13(sb, c, CAPITAL_Z, 65);
                continue;
            }

            if (isSmallAlphabet(c)) {
                makeROT13(sb, c, SMALL_Z, 97);
                continue;
            }

            sb.append(c);
        }

        System.out.println(sb);
    }

    private static void makeROT13(StringBuilder sb, char c, int z, int a) {
        if (c + MOVE > z) {
            sb.append((char) (c + MOVE - z + a - 1));
        } else {
            sb.append((char) (c + MOVE));
        }
    }

    private static boolean isCapitalAlphabet(char c) {
        return 65 <= c && c <= 90;
    }

    private static boolean isSmallAlphabet(char c) {
        return 97 <= c && c <= 122;
    }
}
