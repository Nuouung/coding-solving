package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfAlphabet {

    private static final int[] resultArray = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++)
            resultArray[s.charAt(i) - 97]++; // 'a' = 97

        StringBuilder sb = new StringBuilder();
        for (int i : resultArray) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
