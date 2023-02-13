package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HideYourself6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArray1 = br.readLine().split(" ");
        String N = sArray1[0];
        String myPosition = sArray1[1];
        String[] sArray2 = br.readLine().split(" ");

        long[] array = new long[sArray2.length];
        for (int i = 0; i < sArray2.length; i++) {
            array[i] = Math.abs(Long.parseLong(myPosition) - Long.parseLong(sArray2[i]));
        }

        long gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = getGcd(gcd, array[i]);
        }

        System.out.println(gcd);
    }

    static long getGcd(long a, long b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
