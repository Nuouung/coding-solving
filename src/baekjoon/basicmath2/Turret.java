package baekjoon.basicmath2;

import java.util.Scanner;

public class Turret {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {

            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();

            System.out.println(solution(x1, y1, r1, x2, y2, r2));
        }

    }

    public static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {

        // 접점이 무한대일 때
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        double conditionalStatement = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        double r1PlusR2Squared = Math.pow((r1 + r2), 2);
        double r2MinusR1Squared = Math.pow((r2 - r1), 2);

        // 접점이 없을 때
        if (conditionalStatement > r1PlusR2Squared || conditionalStatement < r2MinusR1Squared) {
            return 0;
        }

        // 접점이 하나일 때
        if (conditionalStatement == r2MinusR1Squared || conditionalStatement == r1PlusR2Squared) {
            return 1;
        }

        // 접점이 두개일 때
        return 2;
    }

}
