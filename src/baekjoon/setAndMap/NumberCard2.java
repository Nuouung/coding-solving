package baekjoon.setAndMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberCard2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Map<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int nextInt = in.nextInt();
            if (!cardMap.containsKey(nextInt)) {
                cardMap.put(nextInt, 1);
                continue;
            }

            Integer n = cardMap.get(nextInt);
            cardMap.put(nextInt, ++n);
        }

        int M = in.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int nextInt = in.nextInt();
            if (cardMap.containsKey(nextInt))
                sb.append(cardMap.get(nextInt)).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
