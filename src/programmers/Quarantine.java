package programmers;

public class Quarantine {

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Quarantine q = new Quarantine();
        for (int i : q.solution(places)) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[][] places) {

        int[] resultArray = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            int result = getResult(places[i]);
            resultArray[i] = result;
        }

        return resultArray;
    }

    private int getResult(String[] place) {
        char[][] board = getBoard(place);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'P') {
                    if(!isDistanceGood(board, i, j, 0)) return 0;
                }
            }
        }
        return 1;
    }

    private boolean isDistanceGood(char[][] board, int i, int j, int depth) {
        if (depth == 3) {
            return true;
        }

        if (depth == 0) board[i][j] = 'O';
        if (board[i][j] == 'P') return false;
        if (board[i][j] == 'X') return true;

        boolean conditionL = j - 1 < 0 || isDistanceGood(board, i, j - 1, depth + 1);
        boolean conditionR = j + 1 >= board.length || isDistanceGood(board, i, j + 1, depth + 1);
        boolean conditionU = i - 1 < 0 || isDistanceGood(board, i - 1, j, depth + 1);
        boolean conditionD = i + 1 >= board.length || isDistanceGood(board, i + 1, j, depth + 1);

        if (depth == 0) board[i][j] = 'P';

        return conditionL && conditionR && conditionU && conditionD;
    }

    private char[][] getBoard(String[] place) {
        char[][] board = new char[place.length][place.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = place[i].charAt(j);
            }
        }

        return board;
    }
}
