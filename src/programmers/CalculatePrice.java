package programmers;

import java.math.BigInteger;

public class CalculatePrice {

    public static void main(String[] args) {
        CalculatePrice cp = new CalculatePrice();
        System.out.println(cp.solution(3, 30, 4));
    }

    public long solution(int price, int money, int count) {
        long totalCount = 0;
        for (int i = 0; i < count; i++) {
            totalCount += i + 1;
        }

        return (long) price * totalCount - money;
    }
}
