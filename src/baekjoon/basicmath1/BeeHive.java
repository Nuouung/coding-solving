package baekjoon.basicmath1;

import java.util.*;
import java.util.Scanner;

public class BeeHive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Integer> list = new ArrayList<>();

        // an = 3n(n-1) + 1
        int n = 1;
        while (3 * n * (n - 1) + 1 <= 1000000000) {
            list.add(3 * n * (n - 1) + 1);
            n++;
        }

        boolean check = true;
        if (N > 999899377) {
            System.out.println(18258);
            check = false;
        }

        if (check) {
            int i = 0;
            while (N > list.get(i)) {
                i++;
            }
            i++;
            System.out.println(i);
        }
    }

}
