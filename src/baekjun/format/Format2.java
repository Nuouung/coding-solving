package baekjun.format;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Format2 {

    // 3
    // 1 3
    // 2 3
    // 1 2

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++) {
            String s = br.readLine();
        }
    }
}
