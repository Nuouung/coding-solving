package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAlphabet {

    private static final int[] resultArray = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Arrays.fill(resultArray, -1);
        for (int i = 0; i < s.length(); i++) {
            if (resultArray[s.charAt(i)- 97] == -1) {
                resultArray[s.charAt(i) - 97] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : resultArray) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
