package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfAlphabet2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] result = new int[26];
        Arrays.fill(result, -1);

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) - 'a'] == -1) result[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
