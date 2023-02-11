package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDAndLCM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArray = br.readLine().split(" ");
        long a = Long.parseLong(sArray[0]);
        long b = Long.parseLong(sArray[1]);

        long gcd = gcd(a, b);
        long lcm = lcm(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    static long lcm(long a, long b, long gcd) {
        return a * b / gcd;
    }
}
