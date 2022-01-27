package baekjoon.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HanNumber {



    public static int solution(int N) {

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            List<Integer> hanList = new ArrayList<>();
            while (temp != 0) {
                hanList.add(temp % 10);
                temp = temp / 10;
            }

            Integer i1 = hanList.get(0);
            hanList.remove(i1);
            if (hanList.isEmpty()) {
                count++;
                continue;
            }
            Integer i2 = hanList.get(0);
            hanList.remove(i2);

            int distance = i2 - i1;
            int previous = i2;

            boolean check = true;
            for (Integer current : hanList) {
                if (current - previous != distance) {
                    check = false;
                }
            }

            if (check) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextInt()));
        in.close();
    }

}
