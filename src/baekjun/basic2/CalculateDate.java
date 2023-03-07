package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CalculateDate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int year, e, s, m;
        year = e = s = m = 1;

        while (!isThisYear(data, e, s, m)) {
            year++;
            e++;
            s++;
            m++;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }

        System.out.println(year);
    }

    private static boolean isThisYear(String[] data, int e, int s, int m) {
        return e == Integer.parseInt(data[0]) &&
                s == Integer.parseInt(data[1]) &&
                m == Integer.parseInt(data[2]);
    }
}