package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] array = br.readLine().split(" ");
        System.out.println(getNumber(array[0], array[1]) + getNumber(array[2], array[3]));
    }

    static long getNumber(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        return Long.parseLong(sb.append(b).toString());
    }
}
