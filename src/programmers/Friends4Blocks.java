package programmers;

import java.util.Arrays;

public class Friends4Blocks {

    public static void main(String[] args) {
        Friends4Blocks f = new Friends4Blocks();
        System.out.println(f.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    public int solution(int m, int n, String[] b) {
        //  라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)
        String[][] board = getBoard(m, n, b);
        boolean[][] visited = new boolean[m][n];

        int result = 0;
        while (true) {
            int temp = 0;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    temp += calculate(i, j, board, visited);
                }
            }

            String[] store = new String[n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i + 1][j])
                }
            }

            result += temp;
            if (temp == 0) break;
        }

        return result;
    }

    private int calculate(int i, int j, String[][] board, boolean[][] visited) {
        int result = 0;

        boolean conditionA = !board[i][j].equals("X") && board[i][j].equals(board[i][j + 1]);
        boolean conditionB = !board[i][j].equals("X") && board[i][j].equals(board[i + 1][j]);
        boolean conditionC = !board[i + 1][j].equals("X") && board[i + 1][j].equals(board[i + 1][j + 1]);

        if (conditionA && conditionB && conditionC) {
            result += !visited[i][j] ? 1 : 0;
            result += !visited[i][j + 1] ? 1 : 0;
            result += !visited[i + 1][j] ? 1 : 0;
            result += !visited[i + 1][j + 1] ? 1 : 0;

            visited[i][j] = true;
            visited[i][j + 1] = true;
            visited[i + 1][j] = true;
            visited[i + 1][j + 1] = true;
        }

        return result;
    }

    private String[][] getBoard(int m, int n, String[] b) {
        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.toString(b[i].charAt(j));
            }
        }

        return board;
    }
}
