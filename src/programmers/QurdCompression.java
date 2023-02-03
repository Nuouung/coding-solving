package programmers;

public class QurdCompression {

    int[] result = new int[2];

    public int[] solution(int[][] arr) {
        recursion(arr, 0, 0, arr.length);
        return result;
    }

    void recursion(int[][] arr, int x, int y, int number) {
        if (inspect(arr, x, y, number)) {
            bindDataToResult(arr, x, y);
            return;
        }

        int dividedNumber = number / 2;
        recursion(arr, x, y, dividedNumber);
        recursion(arr, x + dividedNumber, y, dividedNumber);
        recursion(arr, x, y + dividedNumber, dividedNumber);
        recursion(arr, x + dividedNumber, y + dividedNumber, dividedNumber);
    }

    private void bindDataToResult(int[][] arr, int x, int y) {
        if (arr[x][y] == 1) {
            result[1] = result[1] + 1;
            return;
        }

        result[0] = result[0] + 1;
    }

    boolean inspect(int[][] arr, int x, int y, int number) {
        boolean isAllSame = true;
        int target = arr[x][y];
        for (int i = x; i < x + number; i++) {
            for (int j = y; j < y + number; j++) {
                if (arr[i][j] != target) {
                    isAllSame = false;
                    break;
                }
            }
        }

        return isAllSame;
    }
}
