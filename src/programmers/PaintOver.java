package programmers;

import java.util.Arrays;

public class PaintOver {

    int result = 0;

    public static void main(String[] args) {
        PaintOver p = new PaintOver();
        System.out.println(p.solution(8, 4, new int[]{2,3,6}));
    }

    public int solution(int n, int m, int[] section) {
        Arrays.sort(section);

        int paintStart = 0;

        for (int s : section) {
            if (s > paintStart) {
                paintStart = s + m - 1;
                result++;
            }
        }

        return result;
    }
}
