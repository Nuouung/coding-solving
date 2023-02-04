package programmers;

public class N2Array {
    public static void main(String[] args) {
        N2Array n = new N2Array();
        n.solution(3, 2, 5);
    }

    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];

        int resultIndex = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            result[resultIndex++] = (int) Math.max(row, col) + 1    ;
        }

        return result;
    }
}
