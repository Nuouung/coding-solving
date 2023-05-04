package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaingCalendar {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            String[] array = br.readLine().split(" ");

            int M = Integer.parseInt(array[0]);
            int N = Integer.parseInt(array[1]);
            int x = Integer.parseInt(array[2]);
            int y = Integer.parseInt(array[3]);

            int year = x;
            int last = LCM(N, M);

            while (true) {
                if (year > last) {
                    System.out.println(-1);
                    break;
                }

                if (((year % N) == 0 ? N : year % N) == y) {
                    System.out.println(year);
                    break;
                }

                year = year + M;
            }
        }
    }

    public static int LCM(int A, int B) {
        return A * B / GCD(A, B);
    }

    public static int GCD(int A, int B) {
        int temp = 0;
        while (B > 0) {
            temp = A % B;
            A = B;
            B = temp;
        }

        return A;
    }
}
