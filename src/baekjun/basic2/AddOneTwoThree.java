package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOneTwoThree {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            count = 0;
            recur(Integer.parseInt(br.readLine()), 0);
            System.out.println(count);
        }
    }

    private static void recur(int target, int current) {
        if (current > target) return;

        if (current == target) {
            count++;
            return;
        }

        for (int i = 1; i <= 3; i++)
            recur(target, current + i);
    }
}
