package programmers;

import java.util.Arrays;

public class NumberNDistanceX {

    public long[] solution(int x, int n) {
        long[] array = new long[n];
        Arrays.setAll(array, i -> (long) x * (i + 1));

        return array;
    }
}
