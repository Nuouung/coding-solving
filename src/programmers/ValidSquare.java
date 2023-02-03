package programmers;

import java.util.*;

public class ValidSquare {

    Map<Integer, Double> coordinate = new HashMap<>();

    public static void main(String[] args) {
        ValidSquare v = new ValidSquare();
        System.out.println(v.solution(3, 7));
    }

    public long solution(int x, int y) {
        long result = 0;
        for (int i = 1; i < x; i++) {
            double yValue = ((double) y / x) * i;

            result += yValue;
        }

        return result * 2;
    }
}
