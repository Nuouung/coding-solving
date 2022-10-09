package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] sArray = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArray[i] = s.substring(i);
        }

        Arrays.sort(sArray);

        for (String s1 : sArray) {
            System.out.println(s1);
        }
    }
}
