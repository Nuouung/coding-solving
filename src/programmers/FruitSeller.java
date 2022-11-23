package programmers;

import java.util.Arrays;

public class FruitSeller {

    public static void main(String[] args) {
        FruitSeller f = new FruitSeller();
        System.out.println(f.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    public int solution(int k, int m, int[] score) {
        int result = 0;
        Arrays.sort(score);

        int count = m;
        for (int i = score.length - 1; i >= 0; i--) {
            if (count == 1) {
                result += m * score[i];
                count = m;
            } else {
                count--;
            }
        }
        return result;
    }
}
