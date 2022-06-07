package baekjoon.setAndMap;

import java.util.*;

public class StringSet {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String NM = in.nextLine();
        int N = Integer.parseInt(NM.split(" ")[0]);
        int M = Integer.parseInt(NM.split(" ")[1]);

        Map<String, Integer> myMap = new HashMap<>();
        for (int i = 0; i < N; i++) myMap.put(in.nextLine(), 0);

        int count = 0;
        for (int i = 0; i < M; i++)
            if (myMap.containsKey(in.nextLine())) count++;

        System.out.println(count);
    }
}
