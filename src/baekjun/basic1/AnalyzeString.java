package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalyzeString {

    static int SMALL_CASE = 0;
    static int CAPITAL_CASE = 1;
    static int NUMBER = 2;
    static int BLANK = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            int[] result = new int[4];
            addCount(result, s);
            printResult(result);
        }
    }

    private static void printResult(int[] result) {
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void addCount(int[] result, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).matches("[a-z]")) {
                result[SMALL_CASE] += 1;
                break;
            }

            if (String.valueOf(s.charAt(i)).matches("[A-Z]")) {
                result[CAPITAL_CASE] += 1;
                break;
            }

            if (String.valueOf(s.charAt(i)).matches("[0-9]")) {
                result[NUMBER] += 1;
                break;
            }

            if (s.charAt(i) == ' ') {
                result[BLANK] += 1;
            }
        }
    }
}
