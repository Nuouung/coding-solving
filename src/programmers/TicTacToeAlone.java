package programmers;

import java.util.Arrays;

public class TicTacToeAlone {

    public static void main(String[] args) {
        TicTacToeAlone t = new TicTacToeAlone();

        System.out.println(t.solution(new String[]{"OOO", "...", "XXX"}));
    }

    final int O = 0;
    final int X = 1;
    final int DOT = 2;

    public int solution(String[] board) {
        int[] counts = countTicTacToe(board);

        if (counts[DOT] == 9 || counts[DOT] == 0) return 1;
        if (counts[O] < counts[X] || counts[O] > counts[X] + 1) return 0;
        if (!isProperTicTacToe(board)) return 0;
        return 1;
    }

    private boolean isProperTicTacToe(String[] board) {
        boolean isTicTacToe = false;

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == '.') continue;

            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)) {
                if (isTicTacToe) return false; // bad tic tac toe

                isTicTacToe = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == '.') continue;

            if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)) {
                if (isTicTacToe) return false; // bad tic tac toe

                isTicTacToe = true;
            }
        }

        if (board[0].charAt(0) != '.') {
            if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
                if (isTicTacToe) return false; // bad tic tac toe

                isTicTacToe = true;
            }
        }

        if (board[2].charAt(0) != '.') {
            if (board[2].charAt(0) == board[1].charAt(1) && board[2].charAt(0) == board[0].charAt(2)) {
                if (isTicTacToe) return false; // bad tic tac toe

                isTicTacToe = true;
            }
        }

        return true;
    }

    private int[] countTicTacToe(String[] board) {
        int dotCount = 0;
        int oCount = 0;
        int xCount = 0;

        for (String s : board) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') oCount++;
                if (s.charAt(j) == 'X') xCount++;
                if (s.charAt(j) == '.') dotCount++;
            }
        }

        return new int[]{oCount, xCount, dotCount};
    }
}
