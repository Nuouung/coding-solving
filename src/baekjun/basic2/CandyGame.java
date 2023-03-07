package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

    static char[][] candy;

    public static void main(String[] args) throws IOException {
        setCandy();

        long max = 0;
        for (int i = 0; i < candy.length; i++) {
            for (int j = 0; j < candy.length; j++) {
                int current = calculateCenter(i, j);
                current = Math.max(current, calculateUp(i - 1, j));
                current = Math.max(current, calculateDown(i + 1, j));
                current = Math.max(current, calculateLeft(i, j - 1));
                current = Math.max(current, calculateRight(i, j + 1));

                if (current > max) max = current;
            }

        }

        System.out.println(max);
    }

    private static int calculateUp(int i, int j) {
        if (i < 0) {
            return 0;
        }

        // candy 이동
        char temp = candy[i + 1][j];
        candy[i + 1][j] = candy[i][j];
        candy[i][j] = temp;

        int result = calculateCenter(i, j);

        // candy 원상복귀
        candy[i][j] = candy[i + 1][j];
        candy[i + 1][j] = temp;

        return result;
    }

    private static int calculateDown(int i, int j) {
        if (i >= candy.length) {
            return 0;
        }

        // candy 이동
        char temp = candy[i - 1][j];
        candy[i - 1][j] = candy[i][j];
        candy[i][j] = temp;

        int result = calculateCenter(i, j);

        // candy 원상복귀
        candy[i][j] = candy[i - 1][j];
        candy[i - 1][j] = temp;

        return result;
    }

    private static int calculateLeft(int i, int j) {
        if (j < 0) {
            return 0;
        }

        // candy 이동
        char temp = candy[i][j + 1];
        candy[i][j + 1] = candy[i][j];
        candy[i][j] = temp;

        int result = calculateCenter(i, j);

        // candy 원상복귀
        candy[i][j] = candy[i][j + 1];
        candy[i][j + 1] = temp;

        return result;
    }

    private static int calculateRight(int i, int j) {
        if (j >= candy.length) {
            return 0;
        }

        // candy 이동
        char temp = candy[i][j - 1];
        candy[i][j - 1] = candy[i][j];
        candy[i][j] = temp;

        int result = calculateCenter(i, j);

        // candy 원상복귀
        candy[i][j] = candy[i][j - 1];
        candy[i][j - 1] = temp;

        return result;
    }

    private static int calculateCenter(int i, int j) {
        // (0, 0) (0, 1) (0, 2)
        // (1, 0) (1, 1) (1, 2)
        // (2, 0) (2, 1) (2, 2)
        // i : 세로축 , j : 가로축

        // 위 아래
        int upDown = 0;
        int iIndex = i - 1;
        while (iIndex >= 0 && candy[iIndex][j] == candy[i][j]) {
            upDown++;
            iIndex--;
        }

        iIndex = i + 1;
        while (iIndex <= candy.length - 1 && candy[iIndex][j] == candy[i][j]) {
            upDown++;
            iIndex++;
        }

        // 좌 우
        int leftRight = 0;
        int jIndex = j - 1;
        while (jIndex >= 0 && candy[i][jIndex] == candy[i][j]) {
            leftRight++;
            jIndex--;
        }

        jIndex = j + 1;
        while (jIndex <= candy.length - 1 && candy[i][jIndex] == candy[i][j]) {
            leftRight++;
            jIndex++;
        }

        return Math.max(upDown, leftRight) + 1;
    }

    private static void setCandy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                candy[i][j] = c[j];
            }
        }
    }
}
