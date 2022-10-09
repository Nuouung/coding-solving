package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalyzeString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            if (s.equals("")) {
                break;
            }

            printResult(s);
        }
    }

    private static void printResult(String s) {
        int smallLetter = 0;
        int capitalLetter = 0;
        int number = 0;
        int space = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (97 <= c && c <= 122) {
                smallLetter++;
                continue;
            }

            if (65 <= c && c <= 90) {
                capitalLetter++;
                continue;
            }

            if (48 <= c && c <= 57) {
                number++;
                continue;
            }

            if (c == ' ') {
                space++;
            }
        }

        System.out.println(smallLetter + " " + capitalLetter + " " + number + " " + space);
    }
}
