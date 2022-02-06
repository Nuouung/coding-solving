package baekjoon.bruteForce;

import java.util.Scanner;

public class RepaintChessboard {

    // 1. 이상적인 체스판을 만든다 (흰색으로 시작 / 검은색으로 시작)
    // 2. 잘라서 써야 하는 체스판을 가져온다.
    // 3. 이상적인 체스판과 잘라서 써야 하는 체스판을 비교하며 칠해야 하는 수를 카운팅한다.

    // 필요 메소드 - 이상적인 체스판을 만드는 메소드 / 잘라서 써야 하는 체스판을 내가 쓸 수 있는 포맷으로 만드는 메소드 / 양 체스판을 비교하는 메소드
    // 검은색은 1, 흰색은 0으로 하겠음

    // ------------------------------------------------------------------------------------------------------------------------- //

    public static int[][] blackStartChessboard = createChessboard(1);
    public static int[][] whiteStartChessboard = createChessboard(0);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] rawChessboard = getRawChessboard(in, x, y);

        int endPointOfX = x - 8;
        int endPointOfY = y - 8;

        // 최대 경우의 수 - 8 * 8 의 모든 블록을 다 색칠해야 하는 경우
        int minCount = 64;
        for (int i = 0; i <= endPointOfX; i++) {
            for (int j = 0; j <= endPointOfY; j++) {
                minCount = Math.min(minCount, countRepaintNumber(i, j, rawChessboard));
            }
        }

        System.out.println(minCount);
    }

    public static int countRepaintNumber(int startPointOfX, int startPointOfY, int[][] rawChessboard) {

        int countStartWithBlack = countRepaintNumber(startPointOfX, startPointOfY, rawChessboard, blackStartChessboard);
        int countStartWithWhite = countRepaintNumber(startPointOfX, startPointOfY, rawChessboard, whiteStartChessboard);

        return Math.min(countStartWithBlack, countStartWithWhite);
    }

    private static int countRepaintNumber(int startPointOfX, int startPointOfY, int[][] rawChessboard, int[][] targetBoard) {
        int count = 0;
        for (int i = startPointOfX; i < startPointOfX + 8; i++) {
            for (int j = startPointOfY; j < startPointOfY + 8; j++) {
                if (targetBoard[i - startPointOfX][j - startPointOfY] != rawChessboard[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] getRawChessboard(Scanner in, int x, int y) {

        int[][] rawChessboard = new int[x][y];
        for (int i = 0; i < x; i++) {
            String nextLine = in.next();
            for (int j = 0; j < y; j++) {
                if (nextLine.charAt(j) == 'W') {
                    rawChessboard[i][j] = 0;
                } else {
                    rawChessboard[i][j] = 1;
                }

            }
            in.nextLine();
        }
        return rawChessboard;
    }

    public static int[][] createChessboard(int color) {

        int[][] chessboard = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = color;
                color = switchColor(color);
            }
            color = switchColor(color);
        }

        return chessboard;
    }

    private static int switchColor(int color) {
        if (color == 1) {
            color = 0;
        } else {
            color = 1;
        }
        return color;
    }

}
